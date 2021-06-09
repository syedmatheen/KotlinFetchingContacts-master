package com.mobiledev.contacts

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.Toast

class AddContact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addcontact)
        title = "KotlinApp"
    }

    fun addContact(view: View) {
        val etContactName: EditText = findViewById(R.id.etName)
        val etContactNumber: EditText = findViewById(R.id.etNumber)
        val name: String = etContactName.text.toString()
        val phone = etContactNumber.text.toString()
        val intent = Intent(ContactsContract.Intents.Insert.ACTION)
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE)
        intent.putExtra(ContactsContract.Intents.Insert.NAME, name)
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone)
        Toast.makeText(this, "Added Contact", Toast.LENGTH_LONG).show()
        startActivityForResult(intent, 1)
        Toast.makeText(this, "Click on back button", Toast.LENGTH_LONG).show()
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        intent: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                finish()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Added Contact", Toast.LENGTH_LONG).show()
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                finish()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

}