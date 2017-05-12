package com.example.hp.deliveryproject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageInstaller;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Property;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Model.User;

/**
 * Created by Lalendra on 5/12/2017.
 */

public class ResetPassword extends AppCompatActivity {
    Button reset;
    private EditText et_email;
    private String Email, Subject, textMsg, ToEmail, FromEmail, Passs;
    Session session = null;
    ProgressDialog pddalog = null;
    Context context = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recoverpassword);
        reset = (Button) findViewById(R.id.recover);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_email = (EditText) findViewById(R.id.emailTXT);
                Email = et_email.getText().toString();
                if (Email.equals("")) {
                    Snackbar mySnackbar = Snackbar.make(getWindow().getDecorView().findViewById(android.R.id.content), "Enter Email to Reset", Snackbar.LENGTH_SHORT);
                    mySnackbar.show();
                } else {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference rootRef = database.getReference("tables");
                    rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.child("users").hasChild(et_email.getText().toString())) {

                                Properties prop = new Properties();
                                prop.put("mail.smtp.host", "smtp.gmail.com");
                                prop.put("mail.smtp.socketFoctoty.port", "465");
                                prop.put("mail.smtp.socketFoctoty.class", " javax.net.ssl.SSLSocketFactory");
                                prop.put("mail.smtp.auth", "true");
                                prop.put("mail.smtp.port", "465");
                                session = Session.getDefaultInstance(prop, new Authenticator() {
                                    @Override
                                    protected PasswordAuthentication getPasswordAuthentication() {
                                        return new PasswordAuthentication("deliveritmad@gmail.com", "deliveritmad123");
                                    }
                                });
                                pddalog = ProgressDialog.show(context, "", "sending Mail...", true);

                                RetreiveFeedTask task = new RetreiveFeedTask();
                                task.execute();


                                Snackbar mySnackbar = Snackbar.make(getWindow().getDecorView().findViewById(android.R.id.content), "User Already Available", Snackbar.LENGTH_SHORT);
                                mySnackbar.show();
                            } else {
                                Snackbar mySnackbar = Snackbar.make(getWindow().getDecorView().findViewById(android.R.id.content), "Invalid Email", Snackbar.LENGTH_SHORT);
                                mySnackbar.show();


                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                }

            }
        });
    }

    class RetreiveFeedTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("deliveritmad@gmail.com"));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress("kasun.silva94@yahoo.com"));
                message.setSubject("Pass Word Reset");
                message.setContent("Your PassWord Is :", "text/html; charset=utf-8");
                Transport.send(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            pddalog.dismiss();
        }


    }

}


