# Koin-Example
With this Android app you can see how the dependency injection library Koin works. In this case I have an interface to check Internent
connectivity (NetworkSystemInterface.kt) and two implementations (MockNetworkSystem.kt, NetworkSystem.kt), so when the app is
launched you can set with implementation will be used. This is very useful when you are developing tests.

## How to use
To use KOIN first of all you have to add this dependency to your build.gradle file:

```
dependencies {
    ....
    // Koin for Android
    compile 'org.koin:koin-android:1.0.2'
}
```

In you Application wrapper you have to start Koin indicating which modules you want to load:
```
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin(this, listOf(AppModule().appModule))
    }
}
```

I have a class with the modules that we want to load:

```
class AppModule {

    val appModule : Module = module{

        // NetworkSystem
        single<NetworkSystemInterface> { NetworkSystem(get()) }

        // DataRepository
        factory { DataRepository(get()) }


        // VIEW MODEL
        viewModel{ GetDataViewModel(get()) }
    }
}
```

And in the classes that you want to inject some component you have to do something similar to this:
```
class ScrollingActivity : AppCompatActivity() {
    val getDataViewModel: GetDataViewModel by viewModel() // This is a ViewModel if not use "by inject()"
    ....
}
```
If you want to check the documentation you can look here: https://insert-koin.io/docs/1.0/getting-started/android/
