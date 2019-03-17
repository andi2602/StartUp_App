package com.example.startup;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.klinker.android.link_builder.Link;
import com.klinker.android.link_builder.LinkBuilder;

public class LoginForm extends AppCompatActivity {

    private EditText inputName, inputEmail, inputPassword;
    private TextInputLayout inputLayoutName, inputLayoutEmail, inputLayoutPassword;
    private CardView cardview;
    private CheckBox checkBox;
    @Override
    public void onResume()
    {
        super.onResume();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        inputLayoutName = findViewById(R.id.input_layout_name);
        inputLayoutEmail = findViewById(R.id.input_layout_email);
        inputLayoutPassword = findViewById(R.id.input_layout_password);
        inputName = findViewById(R.id.input_name);
        inputEmail = findViewById(R.id.input_email);
        inputPassword = findViewById(R.id.input_password);
        cardview = findViewById(R.id.cardView);
        checkBox = findViewById(R.id.privacy);


        inputName.addTextChangedListener(new MyTextWatcher(inputName));
        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));


        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
        TextView demoText = findViewById(R.id.privacy);

// create the link builder object add the link rule
        LinkBuilder.on(demoText)
                .addLink(link)
                .build(); // create the clickable links
    }
    private void submitForm() {
        if (!validateName()) {
            return;
        }

        if (!validateEmail()) {
            return;
        }

        if (!validatePassword()) {
            return;
        }
        if (!checkBox.isChecked())
        {
            return;
        }

        Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginForm.this, Workshops.class);
        startActivity(intent);
    }
    private boolean validateName() {
        if (inputName.getText().toString().trim().isEmpty()) {
            inputLayoutName.setError(getString(R.string.err_msg_name));
            requestFocus(inputName);
            return false;
        }
        else {
            inputLayoutName.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateEmail() {
        String email = inputEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            inputLayoutEmail.setError(getString(R.string.err_msg_email));
            requestFocus(inputEmail);
            return false;
        }
        else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePassword() {
        if (inputPassword.getText().toString().trim().length() != 6) {
            inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(inputPassword);
            return false;
        }
        else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    public void checkboxChecked(View view) {

        CheckBox checkBox = (CheckBox)view;
        if (checkBox.isChecked())
        {
            if (inputName.getText().toString().trim().isEmpty()) {
                return;
            }

            if (inputEmail.getText().toString().trim().isEmpty() || !isValidEmail(inputEmail.getText().toString().trim())) {
                return;
            }

            if (inputPassword.getText().toString().trim().length() != 6) {
                return;
            }
            if (!checkBox.isChecked())
            {
                return;
            }
            cardview.setCardBackgroundColor(0xFFFFFFFF);;
        }
        else
            cardview.setCardBackgroundColor(0x66FFFFFF);
    }
    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_name:
                    validateName();
                    if (inputName.getText().toString().trim().isEmpty()) {
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(0x66FFFFFF);

                    if (inputEmail.getText().toString().trim().isEmpty() || !isValidEmail(inputEmail.getText().toString().trim())) {
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(0x66FFFFFF);

                    if (inputPassword.getText().toString().trim().length() != 6) {
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(0x66FFFFFF);
                    if (!checkBox.isChecked())
                    {
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(0x66FFFFFF);
                    cardview.setCardBackgroundColor(0xFFFFFFFF);
                    break;
                case R.id.input_email:
                    validateEmail();
                    if (inputName.getText().toString().trim().isEmpty()) {
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(0x66FFFFFF);

                    if (inputEmail.getText().toString().trim().isEmpty() || !isValidEmail(inputEmail.getText().toString().trim())) {
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(0x66FFFFFF);

                    if (inputPassword.getText().toString().trim().length() != 6) {
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(0x66FFFFFF);
                    if (!checkBox.isChecked())
                    {
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(0x66FFFFFF);
                    cardview.setCardBackgroundColor(0xFFFFFFFF);
                    break;
                case R.id.input_password:
                    validatePassword();
                    if (inputName.getText().toString().trim().isEmpty()) {
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(0x66FFFFFF);

                    if (inputEmail.getText().toString().trim().isEmpty() || !isValidEmail(inputEmail.getText().toString().trim())) {
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(0x66FFFFFF);

                    if (inputPassword.getText().toString().trim().length() != 6) {
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(0x66FFFFFF);
                    if (!checkBox.isChecked())
                    {
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(0x66FFFFFF);
                    cardview.setCardBackgroundColor(0xFFFFFFFF);
                    break;
            }
        }
    }
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    // Create the link rule to set what text should be linked.
// can use a specific string or a regex pattern
    Link link = new Link("terms")
            .setTextColor(Color.parseColor("#79FCEF"))                  // optional, defaults to holo blue
            .setTextColorOfHighlightedLink(Color.parseColor("#0D3D0C")) // optional, defaults to holo blue
            .setHighlightAlpha(.4f)                                     // optional, defaults to .15f
            .setUnderlined(false)                                       // optional, defaults to true
            .setBold(true)                                              // optional, defaults to false
            .setOnLongClickListener(new Link.OnLongClickListener() {
                @Override
                public void onLongClick(String clickedText) {
                    openLink();
                }
            })
            .setOnClickListener(new Link.OnClickListener() {
                @Override
                public void onClick(String clickedText) {
                    // single clicked
                    openLink();
                }
            });

    private void openLink() {
        startActivity(new Intent(LoginForm.this,Terms.class));
    }
}