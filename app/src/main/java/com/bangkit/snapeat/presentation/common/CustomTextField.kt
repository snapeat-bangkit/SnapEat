package com.bangkit.snapeat.presentation.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bangkit.snapeat.R
import com.bangkit.snapeat.presentation.register.RegisterScreen
import com.bangkit.snapeat.ui.theme.DarkBrown
import com.bangkit.snapeat.ui.theme.GrayOrange
import com.bangkit.snapeat.ui.theme.Orange
import com.bangkit.snapeat.ui.theme.SnapEatTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    textValue: MutableState<TextFieldValue>,
    text: String,
    leadingIcon: ImageVector = Icons.Filled.Person,
) {
    OutlinedTextField(
        value = textValue.value,
        onValueChange = { textValue.value = it },
        placeholder = { Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = GrayOrange
        ) },
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType =  KeyboardType.Text,
        ),
        textStyle = MaterialTheme.typography.bodyMedium.copy(
            color = Color.White
        ),
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null,
                tint = Orange
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = DarkBrown,
            focusedBorderColor = Orange,
            unfocusedBorderColor = DarkBrown
            ),
        shape = RoundedCornerShape(8.dp)
    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomEmailField(
    emailValue: MutableState<TextFieldValue>,
) {
    OutlinedTextField(
        value = emailValue.value,
        onValueChange = { emailValue.value = it },
        placeholder = { Text(
            text = "Masukkan Username",
            style = MaterialTheme.typography.bodyMedium,
            color = GrayOrange
        ) },
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
        ),
        textStyle = MaterialTheme.typography.bodyMedium,
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = null,
                tint = Orange
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = DarkBrown,
            focusedBorderColor = Orange,
            unfocusedBorderColor = DarkBrown
        ),
        shape = RoundedCornerShape(8.dp)
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomPasswordField(
    passwordValue: MutableState<TextFieldValue>,
) {
    val passwordVisible by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = passwordValue.value,
        onValueChange = { passwordValue.value = it },
        placeholder = { Text(
            text = "Masukkan Password",
            style = MaterialTheme.typography.bodyMedium,
            color = GrayOrange
        ) },
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        textStyle = MaterialTheme.typography.bodyMedium,
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Lock,
                contentDescription = null,
                tint = Orange
            )
        },
        trailingIcon = {
            val painter = if (passwordVisible) painterResource(id = R.drawable.baseline_visibility_24) else painterResource(id = R.drawable.baseline_visibility_off_24)
            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(
                onClick = {}
            ) {
                Icon(
                    painter = painter,
                    contentDescription = description,
                    tint = Orange)
            }

        },
        visualTransformation = if (!passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = DarkBrown,
            focusedBorderColor = Orange,
            unfocusedBorderColor = DarkBrown
        ),
        shape = RoundedCornerShape(8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun CustomTextFieldPreview(){
    SnapEatTheme {
        val emailValue = remember { mutableStateOf(TextFieldValue()) }
        CustomTextField(emailValue, "Masukkan Email")
    }
}

@Preview(showBackground = true)
@Composable
fun CustomEmailFieldPreview(){
    SnapEatTheme {
        val emailValue = remember { mutableStateOf(TextFieldValue()) }
        CustomEmailField(emailValue)
    }
}

@Preview(showBackground = true)
@Composable
fun CustomPasswordFieldPreview() {
    SnapEatTheme {
        val emailValue = remember { mutableStateOf(TextFieldValue()) }
        CustomPasswordField(emailValue)
    }
}