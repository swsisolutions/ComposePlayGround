package com.swasi.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swasi.ui.R
import com.swasi.ui.theme.Colors

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    text: String = "Hello",
    buttonColor: Color = Colors.teal700,
    textColor: Color = Color.White,
    enabled: Boolean = true,
    onClick: (() -> Unit),
    radios: Int = 8
) {

    val color = remember { mutableStateOf(buttonColor) }

    Button(
        modifier = Modifier
            .padding(8.dp)
            .then(modifier),
        onClick = {onClick()},
        shape = RoundedCornerShape(radios.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = color.value,
            contentColor = textColor
        )
    ) {
        Text(color = textColor, text = text)
    }
}

@Preview
@Composable
fun AppButtonEnablePreview() {
    AppButton(onClick = {})
}

//@ExperimentalComposeUiApi
@Composable
fun AppButtonDisable(
    modifier: Modifier = Modifier,
    title: String = "Hello",
    buttonColor: Color = Color.Gray,
    textColor: Color = Color.White,
    onClick: (() -> Unit),
    radios: Int = 8,
    enable: Boolean = true
) {

    val color = remember { mutableStateOf(buttonColor) }

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(radios.dp),
        enabled = enable,
        colors = ButtonDefaults.buttonColors(
            containerColor = color.value,
            contentColor = textColor
        ),
        modifier = Modifier
            .padding(8.dp)
            /*.pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        color.value = Colors.teal700
                    }

                    MotionEvent.ACTION_UP -> {
                        color.value = Colors.teal200
                    }
                }
                true
            }*/
            .then(modifier)
    ) {
        Text(color = textColor, text = title)
    }
}

@Preview
@Composable
fun AppButtonPreview() {
    AppButtonDisable(title = "Cancel", onClick = {})
}

@Composable
fun AppErrorButtonDisable(
    modifier: Modifier = Modifier,
    title: String = "Error",
    buttonColor: Color = Color.Red,
    textColor: Color = Color.White,
    onClick: (() -> Unit),
    radios: Int = 8
) {

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(radios.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = buttonColor
        ),
        modifier = Modifier
            .padding(8.dp)
            .then(modifier)
    ) {
        Text(color = textColor, text = title)
    }
}

@Preview
@Composable
fun AppButtonErrorPreview() {
    AppErrorButtonDisable(title = "Cancel", onClick = {})
}

@Composable
fun AppButtonWithIcon(
    modifier: Modifier = Modifier,
    title: String = "Hello",
    buttonColor: Color = Colors.teal700,
    textColor: Color = Color.White,
    enabled: Boolean = true,
    onClick: (() -> Unit),
    radios: Int = 8,
    iconDrawable: Int,
    iconContentDesc: String = "content description"
) {

    val color = remember { mutableStateOf(buttonColor) }

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(radios.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = color.value,
            contentColor = textColor
        ),
        modifier = Modifier
            .padding(8.dp)
            .then(modifier)
    ) {
        Image(
            painterResource(id = iconDrawable),
            contentDescription = iconContentDesc,
            modifier = Modifier.size(20.dp)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(color = textColor, text = title)
    }
}

@Preview
@Composable
fun AppButtonIconPreview() {
    AppButtonWithIcon(
        title = "AppButton with Icon",
        onClick = {},
        iconDrawable = R.drawable.ic_rabit
    )
}

@Composable
fun AppOutlinedButton(
    modifier: Modifier = Modifier,
    text: String = "Hello",
    textColor: Color = Color.White,
    onClick: (() -> Unit),
    radios: Int = 8
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(radios.dp)
    ) {
        Text(
            text = text, Modifier.padding(start = 10.dp),
            color = textColor
        )
    }
}

@Preview
@Composable
fun OutlinedAppButtonPreview() {
    AppOutlinedButton(
        onClick = {}
    )
}

@Composable
fun AppOutlinedErrorButton(
    modifier: Modifier = Modifier,
    text: String = "Hello",
    textColor: Color = Color.Red,
    onClick: (() -> Unit),
    radious: Int = 8
) {
    Button(
        modifier = Modifier
            .padding(8.dp)
            .then(modifier)
            .border(
                width = 1.dp,
                color = textColor,
                shape = RoundedCornerShape(radious)
            ),
        onClick = {onClick()},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor =  Color.Transparent
        )
    ) {
        Text(color = textColor, text = text)
    }
}

@Preview
@Composable
fun OutlinedAppErrorButtonPreview() {
    AppOutlinedErrorButton(
        onClick = {}
    )
}

@Composable
fun DisableButton(
    title: String = "Button",
    onClick: (() -> Unit),
    radios: Int = 5,
    textColor: Color = Color.White
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(radios.dp),
        enabled = false,
        colors = ButtonDefaults.buttonColors(
            contentColor = textColor
        ), modifier = Modifier.padding(10.dp)
    ) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Favorite",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(title)
    }
}

@Composable
fun ButtonWithTwoTextView() {
    Button(onClick = {
        //your onclick code here
    }) {
        Text(text = "Click ", color = Color.Magenta)
        Text(text = "Here", color = Color.Green)
    }
}

@Composable
fun ButtonWithElevation() {
    Button(
        onClick = {
            //your onclick code here
        }, elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(text = "Button with elevation")
    }
}

@Composable
fun GradientButton(
    text: String,
    gradient: Brush,
    modifier: Modifier = Modifier,
    textColor: Color = LocalContentColor.current,
    textModifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(100),
    elevation: ButtonElevation? = null,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        modifier = modifier.then(Modifier.background(gradient, shape)),
        enabled = enabled,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent
        ),
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
    ) {
        Box(
            Modifier,
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                modifier = textModifier,
                color = textColor,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun CheckboxText(
    text: String,
    checked: Boolean,
    modifier: Modifier = Modifier,
    checkboxModifier: Modifier = Modifier,
    enabled: Boolean = true,
    onCheckedChange: ((Boolean) -> Unit)
) {
    Row {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = checkboxModifier,
            enabled = enabled
        )
        TextButton(
            modifier = modifier,
            onClick = { onCheckedChange(!checked) }
        ) {
            Text("I'm a Text Button")
        }
    }
}

@Composable
fun LabeledSwitch(
    label: Pair<String, String>, // first: off, second: on
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    textColor: Color = Color.Unspecified,
    switchState: MutableState<Boolean> = remember { mutableStateOf(false) },
    onChange: (Boolean) -> Unit
) {
    Row(modifier) {
        Switch(
            checked = switchState.value,
            onCheckedChange = { onChange(it); switchState.value = it }
        )
        Text(
            text = if (switchState.value) label.second else label.first,
            modifier = textModifier,
            color = textColor
        )
    }
}

// textTemplate is the all-in-one place to define text color, style and the rest.
//      Main reason is that modifiers don't really define the common attributes
//      of Text(), and it might not look neat for RadioButtons to copy all
//      the parameters of Text().
@Composable
fun RadioButtons(
    options: List<String>,
    currentOption: String, // This does a string match with the options
    modifier: Modifier = Modifier,
    textTemplate: @Composable (String) -> Unit = {
        Text(it, color = MaterialTheme.colorScheme.onSurface)
    },
    onSelect: (Int) -> Unit // This outputs the index chosen
) {
    @Composable
    fun RadioItem(
        option: Pair<Int, String>,
        isSelected: Boolean,
        textTemplate: @Composable (String) -> Unit,
        onSelect: (Int) -> Unit
    ) {
        Button(
            { onSelect(option.first) },
            shape = RectangleShape,
            colors = ButtonDefaults.textButtonColors()
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(selected = isSelected, onClick = { onSelect(option.first) })
                textTemplate(option.second)
            }
        }
    }

    Column(
        Modifier
            .width(IntrinsicSize.Max)
            .background(MaterialTheme.colorScheme.surface)
            .then(modifier)
    ) {
        options.forEachIndexed { i, v ->
            RadioItem(
                Pair(i, v),
                currentOption == v,
                textTemplate,
                onSelect
            )
        }
    }
}


