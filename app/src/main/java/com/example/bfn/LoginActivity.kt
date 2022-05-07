package com.example.bfn

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import com.example.bfn.models.User
import com.example.bfn.util.ApiClient
import com.example.bfn.util.UserSession
import com.example.bfn.R
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


       // supportActionBar?.setDisplayHomeAsUpEnabled(true);
        //login
        val loginBtn = findViewById<Button>(R.id.login_login_btn)
        val emailTXT = findViewById<EditText>(R.id.email_text)
        val pwdTXT = findViewById<EditText>(R.id.pass_text)
        val login_signup_btn = findViewById<Button>(R.id.login_signup_btn)

        loginBtn.setOnClickListener{
            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
            /*if(emailTXT.text.isNullOrBlank())
            {
                emailTXT.error = getString(R.string.champ_vide)

                return@setOnClickListener
            }

            if(pwdTXT.text.isNullOrBlank())
            {
                pwdTXT.error = getString(R.string.champ_vide)

                return@setOnClickListener
            }

            ApiClient.apiService.login(User(email = emailTXT.text.toString(), pwd = pwdTXT.text.toString())).enqueue(
                object : Callback<JsonObject> {
                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {

                        t.printStackTrace()

                    }
                    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                        if (response.isSuccessful && response.body() != null) {
                            val content = response.body()

                            if(response.code() == 200)
                            {

                                val user = content.getAsJsonObject("message")

                                val sharedPref = getSharedPreferences(
                                    getString(R.string.user), Context.MODE_PRIVATE)
                                print(R.string.user)





                                with (sharedPref.edit()) {
                                    putString(getString(R.string.token), user.get("token").asString)
                                    print(user.get("token").asString)
                                    commit()
                                }

                                UserSession.id =
                                    user.get("_id").asString

                                UserSession.firstName =
                                    user.get("firstName").asString

                                UserSession.lastName =
                                    user.get("lastName").asString

                                UserSession.email =
                                    user.get("email").asString

                                UserSession.token =
                                    user.get("token").asString

                                val profilePicture = user.get("img").asString

                                if(!profilePicture.isEmpty())
                                    UserSession.img = profilePicture
                                println(profilePicture)

                                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                                startActivity(intent)
                                finish()

                            }
                            if(response.code() == 201)
                            {
                                Toast.makeText(
                                    this@LoginActivity,
                                    "Error Occurred: ${response.message()}",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                            if(response.code() == 403)
                            {
                                Toast.makeText(
                                    this@LoginActivity,
                                    "Error Occurred: ${response.message()}",
                                    Toast.LENGTH_LONG
                                ).show()
                            }


                        }
                        else {

                            Toast.makeText(
                                this@LoginActivity,
                                "Error Occurred: ${response.message()}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            )*/



        }

        login_signup_btn.setOnClickListener {

            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                NavUtils.navigateUpFromSameTask(this)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}