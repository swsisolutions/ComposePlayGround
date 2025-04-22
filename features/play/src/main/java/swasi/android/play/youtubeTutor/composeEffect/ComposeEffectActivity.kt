package swasi.android.play.youtubeTutor.composeEffect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ComposeEffectActivity : ComponentActivity() {

    private var i = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var text by remember {
                mutableStateOf("")
            }
//            EffectHandlersTheme {
//                Button(onClcik ={text += "#"}){
//                    i++
//                    Text(text = text)
//                }
//            }

            LaunchedEffect(key1 = text) {
                delay(1000L)
                println("THe Text is $text")
            }
//
        }
    }
}

@Composable
fun LaunchedEffectFlowDemo(viewmodel: LaunchedEffectViewModel) {
    LaunchedEffect(key1 = true) {
        viewmodel.sharedFlow.collect { event ->
            when (event) {
                is LaunchedEffectViewModel.ScreenEvents.ShowSnackBar -> {

                }
                is LaunchedEffectViewModel.ScreenEvents.Navigate -> {

                }
                else -> {

                }
            }
        }
    }
}

/**
 * In the above case, we are passing the value true
 * it means it will be render for the first time only
 *
 */

@Composable
fun LaunchedEffectAnimation(counter: Int) {
    val animatable = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    LaunchedEffect(key1 = counter) {
        animatable.animateTo(counter.toFloat())
    }
}

/**
 * In the above case, we are passing counter to the compose
 * That means, when the counter changes, the compose will cancel and launch again
 * It will cancel the old animation and load the new animattion with new counter value
 */

@Composable
fun RememberCoroutineScopeDemo() {
    val scope = rememberCoroutineScope() // its a composable function


//    scope.launch {
//       This is not recommended at all
//    Because, you are creating Coroutines everytime, compose called
//    }

    Button(onClick = {
        // below can be done in case of Call Back
        scope.launch {
            delay(1000L)
            println("Hello World")
        }
    }) {

    }
}

@Composable
fun RememberUpdateStateDemo(onTimeout: () -> Unit) {

    val updatedOnTimeout by rememberUpdatedState(newValue = onTimeout)

    LaunchedEffect(key1 = true) {
        delay(3000L)
//        onTimeout()
        updatedOnTimeout()
    }
}

/**
 * Lets consider a spalash screen, after 3000 milli second, it will pass a callback
 * As we are passing true, so it will call only once, it will not re launch
 * In this case, if we pass any other parameter to the composable (value of onTimeout)
 * then it will not replace the old onTimeout method passed earlier
 *
 * To Overcome this issue, we can use rememberUpdatedState
 */

@Composable
fun DisposableEffectDemo() {
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(key1 = lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_PAUSE) {
                println("On Pause Called")
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}

/**
 *
 */

@Composable
fun SideEffectDemo(nonComponentCounter: Int) {
    SideEffect {
        println("Called After every successful Recomposition")
    }
}


@Composable
fun ProduceStateDemo(countUpTo: Int): State<Int> {
//    return flow<Int> {
//        var value = 0
//        emit(value)
//        while (value < countUpTo) {
//            delay(1000L)
//            value++
//            emit(value)
//        }
//    }.collectAsState(initial = 0)

    return produceState(initialValue = 0) {
        while (value < countUpTo) {
            delay(1000L)
            value++
        }
    }
}

@Composable
fun DerivedStateOfDemo() {
    var counter by remember {
        mutableStateOf(0)
    }
//    val counterText = "The Countter is $counter"
    val counterText by derivedStateOf {
        "The Countter is $counter"
    }
    Button(onClick = { counter++ }) {
        Text(text = counterText)
    }
}

@Composable
fun SnapshotFlowDemo() {

    var counter by remember {
        mutableStateOf(0)
    }

    LaunchedEffect(key1 = counter) {
        snapshotFlow {

        }
    }
}
