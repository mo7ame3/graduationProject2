package com.example.lastgradutionproject.screans.ClientScreans.Report

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.navigation.MillanoScreans
import com.example.lastgradutionproject.screans.ClientScreans.Edit.Gender
import com.example.lastgradutionproject.screans.ClientScreans.Edit.myCountry
import com.example.lastgradutionproject.screans.ClientScreans.Edit.myName
import com.example.lastgradutionproject.screans.ClientScreans.Edit.myPhone
object Gender{
    const val male="Male"
    const val Famale="Famale"
}


@Composable
fun Report(navController: NavController,
           loading:Boolean=false,
           isCreatAcount:Boolean=false,
           onDone:(String,String,String) -> Unit = {nn,cc,poh -> }
) {
    val options= listOf("Wrong Order","Bad Survice","Unfavorable Price","The Order Came Later","Anthor Reson")
    var selectOptions by remember {
        mutableStateOf(options[0])
    }
    val selectGender = remember {
        mutableStateOf("")
    }

    val name = rememberSaveable {
        mutableStateOf("")

    }
    val country = rememberSaveable {
        mutableStateOf("")

    }
    val phone = rememberSaveable {
        mutableStateOf("")

    }

    val keyboardController = LocalSoftwareKeyboardController.current
    val valid = remember(name.value, country.value, phone.value) {
        name.value.trim().isNotEmpty() && country.value.trim().isNotEmpty() && phone.value.trim()
            .isNotEmpty()

    }



    Surface(color = Color.White) {


        Row {
            Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "Arrow back",
                tint = Color.Black,
                modifier = Modifier
                    .size(45.dp)
                    .padding(start = 15.dp, top = 8.dp)
                    .clickable {
                        navController.navigate(MillanoScreans.profilescrean.name)
                    }


            )
            Spacer(modifier = Modifier.width(95.dp))
            Text(
                text = "Report",
                fontWeight = FontWeight.SemiBold,
                fontSize = 19.sp,
                modifier = Modifier
                    .padding(top = 65.dp)
                    .clickable {
                        //navController.navigate(MillanoScreans.editprofile.name)
                    },
                color = Color.Black
            )


        }
        Column(
            //verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 150.dp)
        ) {

            myName(
                modifier = Modifier,
                navController = navController,
                nameState = name,
                // passwordVisibility = passwordVisability,
                labelId = "Enter Your Name",
                enabled = !loading,
                onAction = KeyboardActions {
                    // passwordVisability=passwordVisability
                    if (!valid) return@KeyboardActions
                    onDone(name.value.trim(), country.value.trim(), phone.value.trim())
                })
            Spacer(modifier = Modifier.height(10.dp))
            myCountry(
                modifier = Modifier,
                navController = navController,
                countrystate = country,
                // passwordVisibility = passwordVisability,
                labelId = "Enter Your Country",
                enabled = !loading,
                onAction = KeyboardActions {
                    // passwordVisability=passwordVisability
                    if (!valid) return@KeyboardActions
                    onDone(name.value.trim(), country.value.trim(), phone.value.trim())
                })
            Spacer(modifier = Modifier.height(10.dp))

            myPhone(
                modifier = Modifier,
                navController = navController,
                phonestate = phone,
                // passwordVisibility = passwordVisability,
                labelId = "Phone Number",
                enabled = !loading,
                onAction = KeyboardActions {
                    // passwordVisability=passwordVisability
                    if (!valid) return@KeyboardActions
                    onDone(name.value.trim(), country.value.trim(), phone.value.trim())
                })
            Spacer(modifier = Modifier.height(10.dp))
            Column(modifier = Modifier.padding(start = 10.dp, end = 90.dp)) {
                Text(
                    text = "Gender",
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp,
                    modifier = Modifier,
                    // .padding(top = 38.dp)
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    RadioButton(
                        selected = selectGender.value == Gender.male, onClick = {
                            selectGender.value = Gender.male
                        },
                        colors = RadioButtonDefaults.colors(Color.Green)
                    )
                    Spacer(modifier = Modifier.size(16.dp))

                    Text(
                        text = "Male",
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp,
                        modifier = Modifier.padding(top = 14.dp),
                        // .padding(top = 38.dp)
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    RadioButton(
                        selected = selectGender.value == Gender.Famale, onClick = {
                            selectGender.value = Gender.Famale
                        },
                        colors = RadioButtonDefaults.colors(Color.Green)
                    )
                    Spacer(modifier = Modifier.size(16.dp))

                    Text(
                        text = "Famale",
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp,
                        modifier = Modifier.padding(top = 14.dp),
                        // .padding(top = 38.dp)
                        color = Color.Black
                    )


                }
                Spacer(modifier = Modifier.height(10.dp))

                Text(text = "Reson Of Report", fontSize = 19.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(10.dp))

                options.forEach{option -> 
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .selectable(
                            selected = selectOptions == option,
                            onClick = { selectOptions = option }
                        )
                        .padding(horizontal = 16.dp)) {
                        RadioButton(selected = selectOptions==option, onClick = null)
                        Text(text = option, modifier = Modifier.padding(start = 16.dp))
                        
                    }
                    
                }

            }
        }

    }
}

        @Composable
        fun myname(
            navController: NavController,
            modifier: Modifier = Modifier,
            nameState: MutableState<String>,
            labelId: String = "Enter Your Name",
            enabled: Boolean = true,
            imeAction: ImeAction = ImeAction.Next,
            onAction: KeyboardActions = KeyboardActions.Default,
        ) {
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
        fun myName(
            navController: NavController,
            modifier: Modifier = Modifier,
            nameState: MutableState<String>,
            // passwordVisibility: MutableState<Boolean>,
            labelId: String,
            enabled: Boolean,
            isSingleLine: Boolean = true,
            keyboardType: KeyboardType = KeyboardType.Text,
            imeAction: ImeAction = ImeAction.Next,
            onAction: KeyboardActions = KeyboardActions.Default,
        ) {
            OutlinedTextField(
                value = nameState.value,
                onValueChange = { nameState.value = it },
                modifier = Modifier
                    .padding(start = 18.dp, end = 18.dp)
                    .fillMaxWidth(),
                label = { Text(text = labelId) },
                enabled = enabled, singleLine = isSingleLine,
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = imeAction
                ),
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
                //
                //BorderStroke(width = 5.dp, color = Color.Black)
            )

        }

        @Composable
        fun mycountry(
            navController: NavController,
            modifier: Modifier = Modifier,
            countrystate: MutableState<String>,
            labelId: String = "Enter Your Country",
            enabled: Boolean = true,
            imeAction: ImeAction = ImeAction.Next,
            onAction: KeyboardActions = KeyboardActions.Default,
        ) {
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
        fun myCountry(
            navController: NavController,
            modifier: Modifier = Modifier,
            countrystate: MutableState<String>,
            // passwordVisibility: MutableState<Boolean>,
            labelId: String,
            enabled: Boolean,
            isSingleLine: Boolean = true,
            keyboardType: KeyboardType = KeyboardType.Text,
            imeAction: ImeAction = ImeAction.Next,
            onAction: KeyboardActions = KeyboardActions.Default,
        ) {
            OutlinedTextField(
                value = countrystate.value,
                onValueChange = { countrystate.value = it },
                modifier = Modifier
                    .padding(start = 18.dp, end = 18.dp)
                    .fillMaxWidth(),
                label = { Text(text = labelId) },
                enabled = enabled, singleLine = isSingleLine,
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = imeAction
                ),
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
                //
                //BorderStroke(width = 5.dp, color = Color.Black)
            )

        }

        @Composable
        fun myphone(
            navController: NavController,
            modifier: Modifier = Modifier,
            phonestate: MutableState<String>,
            labelId: String = "Phone Number",
            enabled: Boolean = true,
            imeAction: ImeAction = ImeAction.Next,
            onAction: KeyboardActions = KeyboardActions.Default,
        ) {
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
        fun myPhone(
            navController: NavController,
            modifier: Modifier = Modifier,
            phonestate: MutableState<String>,
            // passwordVisibility: MutableState<Boolean>,
            labelId: String,
            enabled: Boolean,
            isSingleLine: Boolean = true,
            keyboardType: KeyboardType = KeyboardType.Text,
            imeAction: ImeAction = ImeAction.Next,
            onAction: KeyboardActions = KeyboardActions.Default,
        ) {
            OutlinedTextField(
                value = phonestate.value,
                onValueChange = { phonestate.value = it },
                modifier = Modifier
                    .padding(start = 18.dp, end = 18.dp)
                    .fillMaxWidth(),
                label = { Text(text = labelId) },
                enabled = enabled, singleLine = isSingleLine,
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = imeAction
                ),
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
                //
                //BorderStroke(width = 5.dp, color = Color.Black)
            )

        }


