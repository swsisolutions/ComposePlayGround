package com.swasi.uikit.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ComposeTextField(
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onTextChanged: (String) -> Unit,
    onNext: ((KeyboardActionScope) -> Unit)? = null,
    onDone: ((KeyboardActionScope) -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    modifier: Modifier = Modifier.padding(0.dp)
) {
    var text by remember {
        mutableStateOf("")
    }

    TextField(
        modifier = Modifier.composed { modifier },
        value = text,
        onValueChange = {
            text = it
            onTextChanged(it)
        },
        label = {
            Text(label)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onDone = onDone?.let { it },
            onNext = onNext?.let { it }
        ),
        isError = isError,
        visualTransformation = visualTransformation
    )
}

@Composable
fun ComposeTextFieldWithIcon(
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onTextChanged: (String) -> Unit,
    onNext: ((KeyboardActionScope) -> Unit)? = null,
    onDone: ((KeyboardActionScope) -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    modifier: Modifier = Modifier.padding(0.dp),
    icon: ImageVector = Icons.Default.Email,
    iconColor: Color = Color.Black
) {
    var text by remember {
        mutableStateOf("")
    }

    TextField(
        modifier = Modifier.composed { modifier },
        value = text,
        onValueChange = {
            text = it
            onTextChanged(it)
        },
        label = {
            Text(label)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onDone = onDone?.let { it },
            onNext = onNext?.let { it }
        ),
        isError = isError,
        visualTransformation = visualTransformation,
        leadingIcon = {
            Icon(
                imageVector = icon, contentDescription = text,
                tint = iconColor
            )
        }
    )
}


@Composable
fun ComposeOutLinedTextField(
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onTextChanged: (String) -> Unit,
    onNext: ((KeyboardActionScope) -> Unit)? = null,
    onDone: ((KeyboardActionScope) -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    modifier: Modifier = Modifier.padding(0.dp)
) {
    var text by remember {
        mutableStateOf("")
    }
    androidx.compose.material3.OutlinedTextField(
        modifier = Modifier.composed { modifier },
        value = text,
        onValueChange = {
            text = it
            onTextChanged(it)
        },
        label = {
            Text(label)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onDone = onDone?.let { it },
            onNext = onNext?.let { it }
        ),
        isError = isError,
        visualTransformation = visualTransformation
    )
}

@Composable
fun ComposeOutLinedTextFieldWithIcon(
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onTextChanged: (String) -> Unit,
    onNext: ((KeyboardActionScope) -> Unit)? = null,
    onDone: ((KeyboardActionScope) -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    modifier: Modifier = Modifier.padding(0.dp),
    icon: ImageVector = Icons.Default.Email,
    iconColor: Color = Color.Black
) {

    var text by remember {
        mutableStateOf("")
    }

    androidx.compose.material3.OutlinedTextField(
        modifier = Modifier.composed { modifier },
        value = text,
        onValueChange = {
            text = it
            onTextChanged(it)
        },
        label = {
            Text(label)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onDone = onDone?.let { it },
            onNext = onNext?.let { it }
        ),
        isError = isError,
        visualTransformation = visualTransformation,
        leadingIcon = {
            Icon(
                imageVector = icon, contentDescription = text,
                tint = iconColor
            )
        }
    )
}

@Preview
@Composable
fun AppTextFieldPreview() {
    ComposeTextField(label = "", onTextChanged = {

    })
}

@Preview
@Composable
fun AppTextFieldWithIconPreview() {
    ComposeTextFieldWithIcon(label = "", onTextChanged = {

    })
}

@Preview
@Composable
fun AppOutLinedTextFieldPreview() {
    ComposeOutLinedTextField(label = "", onTextChanged = {

    })
}

@Preview
@Composable
fun AppOutLinedTextFieldWithIconPreview() {
    ComposeOutLinedTextFieldWithIcon(label = "", onTextChanged = {

    })
}

@Composable
fun AppEditText(
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current,
    hint: String = "",
    placeholder: String = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    shape: androidx.compose.ui.graphics.Shape = TextFieldDefaults.shape,
    textColor: Color = Color.Blue
) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        label = { Text(text = hint) },
        keyboardOptions = keyboardOptions,
        onValueChange = onValueChange,
        singleLine = singleLine,
        placeholder = { Text(text = placeholder) },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        shape = shape,
        textStyle = textStyle,
        modifier = modifier
            .padding()
            .then(
                modifier
            )
    )
}

@Preview
@Composable
fun AppEditTextPreview() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    AppEditText(
        onValueChange = { newText ->
            text = newText
        },
        hint = "Hello",
        placeholder = "spm",
        textColor = Color.White,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabelAndPlaceHolder() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = { Text(text = "Your Label") },
        placeholder = { Text(text = "Your Placeholder/Hint") },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithInputType() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        label = { Text(text = "Number Input Type") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = { it ->
            text = it
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutLineTextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        label = { Text(text = "Enter Your Name") },
        onValueChange = {
            text = it
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithIcons() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    return OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
        //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
        onValueChange = {
            text = it
        },
        label = { Text(text = "Email address") },
        placeholder = { Text(text = "Enter your e-mail") },
    )
}


@Composable
fun AppEditTextMain(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: androidx.compose.ui.graphics.Shape = TextFieldDefaults.shape,
    colors: TextFieldColors = TextFieldDefaults.colors()
) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        label = { Text(text = "Number Input Type") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = { it ->
            text = it
        }
    )
}