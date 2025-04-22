# Side Effect

- The purpose of side effects in Jetpack Compose is to allow for the execution of non-UI related
  operations that change the state of the app outside of a Composable function in a controlled and
  predictable manner.
- Side effects, such as updating a database or making a network call, should be kept separate from
  the UI rendering logic to improve the performance and maintainability of the code.
- Jetpack Compose provides several Composable functions, such as SideEffect, LaunchedEffect, and
  DisposableEffect, that enable developers to manage side effects effectively, by decoupling them
  from the UI rendering logic and executing them in a separate coroutine scope.

## Benefits of Side Effect

- Improved Performance: By executing non-UI related operations outside of the Composable functions,
  the UI rendering logic can remain responsive and performant.
- Better Code Organization: By separating non-UI related operations from the UI rendering logic, the
  codebase becomes easier to understand and maintain.
- Better Debugging: Side effects can be used for logging and analytics operations, which can help
  developers better understand the behavior of their apps and identify issues.

## Important links

- https://medium.com/@mortitech/exploring-side-effects-in-compose-f2e8a8da946b
- https://developer.android.com/jetpack/compose/side-effects

## Other Important terms

- sideEffect
- EffectHandlersTheme
- LaunchedEffect
- rememberCoroutineScope
- rememberUpdatedState
- DisposableEffect
- SideEffect: publish Compose state to non-compose code
- produceState: convert non-Compose state into Compose state
- derivedStateOf: convert one or multiple state objects into another state
- snapshotFlow: convert Compose's State into Flows

## LaunchedEffect

- **How does LaunchedEffect work?**
- When a composition is recomposed, Jetpack Compose calls the lambda passed to LaunchedEffect.
- This lambda should contain the code that performs the asynchronous operation.
- Once the operation is complete, the coroutine should update the UI using the MutableState or
  MutableStateFlow objects.
- **Here’s a detailed breakdown of LaunchedEffect:**
- **What it does:**
- Launches a coroutine in the background to perform your desired side effect.
- Ensures the coroutine starts only when the composable composition occurs.
- Cancels the coroutine automatically when the composable is removed from the composition.
- Allows specifying dependencies to control the coroutine execution based on changes in data or
  state.
- **Benefits:**
- Improved Composability: Keeps your composable functions pure and focused on UI declaration,
  separating side effects into background coroutines.
- Lifecycle Awareness: Automatically starts and stops coroutines based on the composable lifecycle,
  preventing leaks and unnecessary operations.
- Efficient Updates: Only re-runs coroutines when their dependencies change, optimizing performance
  and avoiding redundant work.

## rememberCoroutineScope

- rememberCoroutineScope is a function that is used to create a CoroutineScope that can be reused
  across the lifecycle of a Composable function.
- It is similar to the viewModelScope in ViewModel, but rememberCoroutineScope is designed
  specifically for Jetpack Compose.
- rememberCoroutineScope() is useful whenever you need to have your coroutine canceled as soon as
  the Composable leaves the Composition.

## rememberUpdatedState

- reference a value in an effect that shouldn't restart if the value changes

## rememberSaveable

## SideEffect

- In the below function the side effect will log the count

```
@Composable
fun Counter() {
    // Define a state variable for the count
    val count = remember { mutableStateOf(0) }

    // Use SideEffect to log the current value of count
    SideEffect {
        // Called on every recomposition
        log("Count is ${count.value}")
    }

    Column {
        Button(onClick = { count.value++ }) {
            Text("Increase Count")
        }

        // With every state update, text is changed and recomposition is triggered
        Text("Counter ${count.value}")
    }
}
```

## LaunchedEffect

- LaunchedEffect is a Composable function that executes a side effect in a separate coroutine scope.
- This function is useful for executing operations that can take a long time, such as network calls
  or animations, without blocking the UI thread.
- To call suspend functions safely from inside a composable, use the LaunchedEffect composable.
- When LaunchedEffect enters the Composition, it launches a coroutine with the block of code passed
  as a parameter.
- The coroutine will be cancelled if LaunchedEffect leaves the composition.

```
LaunchedEffect(snackbarHostState) {
            snackbarHostState.showSnackbar(
                message = "Error message",
                actionLabel = "Retry message"
            )
        }
```

## rememberCoroutineScope

- As LaunchedEffect is a composable function, it can only be used inside other composable functions.
- In order to launch a coroutine outside of a composable, but scoped so that it will be
  automatically canceled once it leaves the composition,
- use rememberCoroutineScope.

```
val scope = rememberCoroutineScope()

inside composable, any action
scope.launch {
            snackbarHostState.showSnackbar("Something happened!")
        }
``` 

## rememberUpdatedState

- LaunchedEffect restarts when one of the key parameters changes.
- However, in some situations you might want to capture a value in your effect that, if it changes,
  you do not want the effect to restart.
- In order to do this, it is required to use rememberUpdatedState to create a reference to this
  value which can be captured and updated.

```
// This will always refer to the latest onTimeout function that
    // LandingScreen was recomposed with
    val currentOnTimeout by rememberUpdatedState(onTimeout)

    // Create an effect that matches the lifecycle of LandingScreen.
    // If LandingScreen recomposes, the delay shouldn't start again.
    LaunchedEffect(true) {
        delay(SplashWaitTimeMillis)
        currentOnTimeout()
    }
```

## DisposableEffect: effects that require cleanup

- For side effects that need to be cleaned up after the keys change or if the composable leaves the
  Composition, use DisposableEffect.
- If the DisposableEffect keys change, the composable needs to dispose (do the cleanup for) its
  current effect, and reset by calling the effect again.

```
@Composable
fun HomeScreen(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    onStart: () -> Unit, // Send the 'started' analytics event
    onStop: () -> Unit // Send the 'stopped' analytics event
) {
    // Safely update the current lambdas when a new one is provided
    val currentOnStart by rememberUpdatedState(onStart)
    val currentOnStop by rememberUpdatedState(onStop)

    // If `lifecycleOwner` changes, dispose and reset the effect
    DisposableEffect(lifecycleOwner) {
        // Create an observer that triggers our remembered callbacks
        // for sending analytics events
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_START) {
                currentOnStart()
            } else if (event == Lifecycle.Event.ON_STOP) {
                currentOnStop()
            }
        }

        // Add the observer to the lifecycle
        lifecycleOwner.lifecycle.addObserver(observer)

        // When the effect leaves the Composition, remove the observer
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    /* Home screen content */
}
```

## SideEffect: publish Compose state to non-compose code

- To share Compose state with objects not managed by compose, use the SideEffect composable, as it's
  invoked on every successful recomposition.

```
@Composable
fun rememberFirebaseAnalytics(user: User): FirebaseAnalytics {
    val analytics: FirebaseAnalytics = remember {
        FirebaseAnalytics()
    }

    // On every successful composition, update FirebaseAnalytics with
    // the userType from the current User, ensuring that future analytics
    // events have this metadata attached
    SideEffect {
        analytics.setUserProperty("userType", user.userType)
    }
    return analytics
}
```

## produceState: convert non-Compose state into Compose state

- produceState launches a coroutine scoped to the Composition that can push values into a returned
  State.
- Use it to convert non-Compose state into Compose state, for example bringing external
  subscription-driven state such as Flow, LiveData, or RxJava into the Composition.

```
@Composable
fun loadNetworkImage(
    url: String,
    imageRepository: ImageRepository = ImageRepository()
): State<Result<Image>> {

    // Creates a State<T> with Result.Loading as initial value
    // If either `url` or `imageRepository` changes, the running producer
    // will cancel and will be re-launched with the new inputs.
    return produceState<Result<Image>>(initialValue = Result.Loading, url, imageRepository) {

        // In a coroutine, can make suspend calls
        val image = imageRepository.load(url)

        // Update State with either an Error or Success result.
        // This will trigger a recomposition where this State is read
        value = if (image == null) {
            Result.Error
        } else {
            Result.Success(image)
        }
    }
}
```

## derivedStateOf: convert one or multiple state objects into another state

- Use derivedStateOf when a certain state is calculated or derived from other state objects.

```
@Composable
fun TodoList(highPriorityKeywords: List<String> = listOf("Review", "Unblock", "Compose")) {

    val todoTasks = remember { mutableStateListOf<String>() }

    // Calculate high priority tasks only when the todoTasks or highPriorityKeywords
    // change, not on every recomposition
    val highPriorityTasks by remember(highPriorityKeywords) {
        derivedStateOf {
            todoTasks.filter { task ->
                highPriorityKeywords.any { keyword ->
                    task.contains(keyword)
                }
            }
        }
    }

    Box(Modifier.fillMaxSize()) {
        LazyColumn {
            items(highPriorityTasks) { /* ... */ }
            items(todoTasks) { /* ... */ }
        }
        /* Rest of the UI where users can add elements to the list */
    }
}
```

## snapshotFlow: convert Compose's State into Flows

- Use snapshotFlow to convert State<T> objects into a cold Flow.
- snapshotFlow runs its block when collected and emits the result of the State objects read in it.

```
val listState = rememberLazyListState()

LazyColumn(state = listState) {
    // ...
}

LaunchedEffect(listState) {
    snapshotFlow { listState.firstVisibleItemIndex }
        .map { index -> index > 0 }
        .distinctUntilChanged()
        .filter { it == true }
        .collect {
            MyAnalyticsService.sendScrolledPastFirstItemEvent()
        }
}
```

## Restarting effects

- Some effects in Compose, like LaunchedEffect, produceState, or DisposableEffect, take a variable
  number of arguments, keys, that are used to cancel the running effect and start a new one with the
  new keys.
- The typical form for these APIs is:

```
    EffectName(restartIfThisKeyChanges, orThisKey, orThisKey, ...) { block }
```

## How to handle lifecycle of Composable

- https://betterprogramming.pub/jetpack-compose-with-lifecycle-aware-composables-7bd5d6793e0
- https://stackoverflow.com/questions/66546962/jetpack-compose-how-do-i-refresh-a-screen-when-app-returns-to-foreground

```
val lifecycleOwner = LocalLifecycleOwner.current
val state by lifecycleOwner.lifecycle.collectStateAsState()

LaunchedEffect(state) {
    // Do something with your state
    // You may want to use DisposableEffect or other alternatives 
    // instead of LaunchedEffect
}
```