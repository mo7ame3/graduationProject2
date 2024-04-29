package com.example.lastgradutionproject.screans.ClientScreans.SignUp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.navigation.MillanoScreans
import com.example.lastgradutionproject.screans.startScrean.nameFailed

@Composable
fun SignUp(navController: NavController,
           loading:Boolean=false,
           isCreatAcount:Boolean=false,
           onDone:(String,String) -> Unit = {email,pass -> }
){
    val Email= rememberSaveable {
        mutableStateOf("")

    }
    val password= rememberSaveable {
        mutableStateOf("")

    }
    var passwordVisability= rememberSaveable {
        mutableStateOf(false)

    }
    val passwordFocusRequest= FocusRequester.Default
    val keyboardController= LocalSoftwareKeyboardController.current
    val valid= remember (Email.value,password.value){
        Email.value.trim().isNotEmpty()&&  password.value.trim().isNotEmpty()

    }

    Column ( verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 120.dp, bottom = 20.dp)
    ) {
        Email(
            navController = navController,
            Email = Email,
            enabled = !loading,
            onAction = KeyboardActions {
                passwordFocusRequest.requestFocus()
            })
        Spacer(modifier = Modifier.height(10.dp))
        passwordFailed(
            modifier = Modifier.focusRequester(passwordFocusRequest),
            navController = navController ,
            passwordState = password,
            passwordVisibility = passwordVisability,
            labelId = "Password",
            enabled = !loading,
            onAction = KeyboardActions{
                // passwordVisability=passwordVisability
                if (!valid) return@KeyboardActions
                onDone(Email.value.trim(),  password.value.trim())

            }
        )
        Spacer(modifier = Modifier.height(100.dp))

        SignUpButton(
            //Text( text = "Select" , fontWeight = FontWeight.SemiBold ),
            loading =loading,
            validInputs =valid
        ){
            onDone( Email.value.trim(),  password.value.trim())
            // navController.navigate(MillanoScreans.LoginScrean.name)

        }
        Spacer(modifier = Modifier.height(80.dp))

        Row (horizontalArrangement = Arrangement.Center){
            Text(modifier = Modifier.padding(),
                text = "New User?", fontSize = 19.sp, fontWeight = FontWeight.SemiBold,
                color = Color.Black)
            Text(modifier = Modifier
                .clickable {
                    navController.navigate(MillanoScreans.LoginScrean.name)
                },
                text = "Login", fontSize = 19.sp, fontWeight = FontWeight.SemiBold,
                color = colorResource(id = R.color.sky)
            )

        }




    }

}

@Composable
fun SignUpButton(loading: Boolean,
                validInputs: Boolean,
                onClick: () -> Unit) {
    Button(          onClick=onClick,
        modifier = Modifier
            .width(3750.dp)
            .height(45.dp)
            .padding(start = 34.dp, end = 34.dp),
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        enabled = !loading && validInputs,
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.sky))
    ) {

        Text(text = "SignUp", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 19.sp)
        if (loading) CircularProgressIndicator(modifier = Modifier.size(25.dp))
    }


}

@Composable
fun Email(navController: NavController,
          modifier: Modifier = Modifier,
          Email: MutableState<String>,
          labelId:String="Email",
          enabled:Boolean=true,
          imeAction: ImeAction = ImeAction.Next,
          onAction: KeyboardActions = KeyboardActions.Default,
){
    nameFailed( navController=navController,
        modifier= Modifier,
        nameState=Email
        ,labelId=labelId,
        enabled=enabled
        ,imeAction=imeAction,
        keyboardType= KeyboardType.Email,
        onAction=onAction)

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun emailFailed(
    navController: NavController,
    modifier: Modifier = Modifier,
    emailState: MutableState<String>,
    labelId:String,
    enabled:Boolean,
    isSingleLine:Boolean=true,
    keyboardType: KeyboardType = KeyboardType.Email,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
) {
    OutlinedTextField(
        value = emailState.value,
        onValueChange = { emailState.value =it},
        modifier= Modifier
            .padding(start = 18.dp, end = 18.dp)
            .fillMaxWidth(),
        label = {Text(text = labelId) },
        enabled = enabled, singleLine = isSingleLine,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction, textStyle = MaterialTheme.typography.bodyLarge,
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            //focusedBorderColor = Color.Transparent,
            //unfocusedBorderColor = Color.Transparent,
            cursorColor = colorResource(id = R.color.Brown),
            // textColor = colorResource(id = R.color.Brown),
            // leadingIconColor = colorResource(id = R.color.Brown),
            //trailingIconColor = colorResource(id = R.color.Brown),
            errorCursorColor = colorResource(id = R.color.Brown),
            errorLeadingIconColor = colorResource(id = R.color.Brown),
            errorTrailingIconColor = colorResource(id = R.color.Brown),
            errorTextColor = colorResource(id = R.color.Brown),
            errorBorderColor = colorResource(id = R.color.Brown),
        ),
        //
        //BorderStroke(width = 5.dp, color = Color.Black)
    )

}
@Composable
fun password(navController: NavController,
             modifier: Modifier = Modifier,
             passwordState: MutableState<String>,
             labelId:String="Password",
             enabled:Boolean=true,
             imeAction: ImeAction = ImeAction.Next,
             onAction: KeyboardActions = KeyboardActions.Default,
){
    /* passwordFailed( navController =navController,
         modifier =Modifier,
         passwordState = passwordState,
         labelId =labelId,
         enabled =enabled
         , imeAction =imeAction,
         keyboardType = KeyboardType.Password,
         passwordVisibility = ,
         onAction =onAction)*/

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun passwordFailed(
    navController: NavController,
    modifier: Modifier = Modifier,
    passwordState: MutableState<String>,
    passwordVisibility: MutableState<Boolean>,
    labelId:String,
    enabled:Boolean,
    isSingleLine:Boolean=true,
    keyboardType: KeyboardType = KeyboardType.Password,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
) {
    val visualTransformation= if(passwordVisibility.value) VisualTransformation.None else
        PasswordVisualTransformation()
    OutlinedTextField(
        value = passwordState.value,
        onValueChange = { passwordState.value=it },
        modifier= Modifier
            .padding(start = 18.dp, end = 18.dp)
            .fillMaxWidth(),
        label = {Text(text = labelId) },
        enabled = enabled, singleLine = isSingleLine,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction, textStyle = MaterialTheme.typography.bodyLarge,
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            //focusedBorderColor = Color.Transparent,
            // unfocusedBorderColor = Color.Transparent,
            cursorColor = colorResource(id = R.color.Brown),
            // textColor = colorResource(id = R.color.Brown),
            // leadingIconColor = colorResource(id = R.color.Brown),
            //trailingIconColor = colorResource(id = R.color.Brown),
            errorCursorColor = colorResource(id = R.color.Brown),
            errorLeadingIconColor = colorResource(id = R.color.Brown),
            errorTrailingIconColor = colorResource(id = R.color.Brown),
            errorTextColor = colorResource(id = R.color.Brown),
            errorBorderColor = colorResource(id = R.color.Brown),
        ),
        visualTransformation = visualTransformation,
        trailingIcon = { com.example.lastgradutionproject.screans.ClientScreans.Login.PasswordVisability(passwordVisibility=passwordVisibility) }
        //
        //BorderStroke(width = 5.dp, color = Color.Black)
    )

}

@Composable
fun PasswordVisability(passwordVisibility: MutableState<Boolean>) {
    val visable=passwordVisibility.value
    IconButton(onClick = { passwordVisibility.value=!visable }) {
        Icons.Default.Close

    }



}