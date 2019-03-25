package com.example.startup;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.klinker.android.link_builder.Link;
import com.klinker.android.link_builder.LinkBuilder;

public class LoginForm extends AppCompatActivity {

    private TextView register;
    private EditText inputName, inputEmail, inputPassword;
    private TextInputLayout inputLayoutName, inputLayoutEmail, inputLayoutPassword;
    private CardView cardview;
    private CheckBox checkBox;
    private DatabaseReference mDatabaseRef;
    private FirebaseAuth mAuth;
    @Override
    public void onResume()
    {
        super.onResume();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isNetworkAvailable())
        {buildDialog(LoginForm.this).show(); }
        else{
        setContentView(R.layout.activity_login_form);
        inputLayoutName = findViewById(R.id.input_layout_name);
        inputLayoutEmail = findViewById(R.id.input_layout_email);
        inputLayoutPassword = findViewById(R.id.input_layout_password);
        inputName = findViewById(R.id.input_name);
        inputEmail = findViewById(R.id.input_email);
        inputPassword = findViewById(R.id.input_password);
        cardview = findViewById(R.id.cardView);
        checkBox = findViewById(R.id.privacy);
        register = findViewById(R.id.register);
        mDatabaseRef = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();


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
    }}
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
        if (!checkBox.isChecked()) {
            return;
        }
        mDatabaseRef.child("Keys").orderByChild("key").equalTo(inputPassword.getText().toString().trim()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        mAuth.createUserWithEmailAndPassword(inputEmail.getText().toString().trim(), inputPassword.getText().toString().trim())
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            Users user = new Users(inputName.getText().toString().trim(), inputEmail.getText().toString().trim(), inputPassword.getText().toString().trim());
                                            FirebaseDatabase.getInstance().getReference("Users")
                                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                    .setValue(user);

                                            Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(LoginForm.this, Workshops.class);
                                            startActivity(intent);
                                            finish();


                                            mDatabaseRef.child("Keys").orderByChild("key").equalTo(inputPassword.getText().toString().trim()).addChildEventListener(new ChildEventListener() {
                                                @Override
                                                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                                                    mDatabaseRef.child("Keys").child(dataSnapshot.getKey()).setValue(null);
                                                }

                                                @Override
                                                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                                                }

                                                @Override
                                                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                                                }

                                                @Override
                                                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                }
                                            });

                                        } else {
                                            Toast.makeText(getApplicationContext(), "Invalid ticket number", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid ticket number or email", Toast.LENGTH_SHORT).show();
                    }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
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
                cardview.setCardBackgroundColor(Color.parseColor("#CE95A5"));
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
            cardview.setCardBackgroundColor(0xFFFFFFFF);
        }
        else
            cardview.setCardBackgroundColor(Color.parseColor("#CE95A5"));
    }
    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            switch (view.getId()) {
                case R.id.input_name:
                    validateName();
                    if (inputName.getText().toString().trim().isEmpty()) {
                        cardview.setCardBackgroundColor(Color.parseColor("#CE95A5"));
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(Color.parseColor("#CE95A5"));

                    if (inputEmail.getText().toString().trim().isEmpty() || !isValidEmail(inputEmail.getText().toString().trim())) {
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(Color.parseColor("#CE95A5"));

                    if (inputPassword.getText().toString().trim().length() != 6) {
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(Color.parseColor("#CE95A5"));
                    if (!checkBox.isChecked())
                    {
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(Color.parseColor("#CE95A5"));
                    cardview.setCardBackgroundColor(0xFFFFFFFF);
                    break;
                case R.id.input_email:
                    validateEmail();
                    if (inputName.getText().toString().trim().isEmpty()) {
                        cardview.setCardBackgroundColor(Color.parseColor("#CE95A5"));
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(Color.parseColor("#CE95A5"));

                    if (inputEmail.getText().toString().trim().isEmpty() || !isValidEmail(inputEmail.getText().toString().trim())) {
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(Color.parseColor("#CE95A5"));

                    if (inputPassword.getText().toString().trim().length() != 6) {
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(Color.parseColor("#CE95A5"));
                    if (!checkBox.isChecked())
                    {
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(Color.parseColor("#CE95A5"));
                    cardview.setCardBackgroundColor(0xFFFFFFFF);
                    break;
                case R.id.input_password:
                    validatePassword();
                    if (inputName.getText().toString().trim().isEmpty()) {
                        cardview.setCardBackgroundColor(Color.parseColor("#CE95A5"));
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(Color.parseColor("#CE95A5"));

                    if (inputEmail.getText().toString().trim().isEmpty() || !isValidEmail(inputEmail.getText().toString().trim())) {
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(Color.parseColor("#CE95A5"));

                    if (inputPassword.getText().toString().trim().length() != 6) {
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(Color.parseColor("#CE95A5"));
                    if (!checkBox.isChecked())
                    {
                        return;
                    }
                    else
                        cardview.setCardBackgroundColor(Color.parseColor("#CE95A5"));
                    cardview.setCardBackgroundColor(0xFFFFFFFF);
                    break;
            }
        }

        public void afterTextChanged(Editable editable) {

        }
    }
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    // Create the link rule to set what text should be linked.
// can use a specific string or a regex pattern
    Link link = new Link("Policy")
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
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }
    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You need to have Mobile Data or Wi-Fi to access this activity. Press OK to Exit");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        return builder;
    }

    private void openLink() {
        startActivity(new Intent(LoginForm.this,Terms.class));
    }
    private void updateUI(FirebaseUser user) {
        if (user != null) {
            startActivity(new Intent(LoginForm.this,Workshops.class));
            finish();
        }
    }
}