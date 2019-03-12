package android.example.myapplication;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);

        //setContentView(R.layout.activity_main);

        preferences = getPreferences(MODE_PRIVATE);
        editor = preferences.edit();

    }

  /*  public void btnLogout(View view){
        android.os.Process.killProcess(android.os.Process.myPid());
    }*/

   /* public void loginLink(View view){
        Intent intent1 = new Intent();
        intent1.setClass(MainActivity.this,Login.class);
        startActivity(intent1);
}*/

   public void btnSignup(View view){
        TextView nm = findViewById(R.id.name);
        String name = nm.getText().toString();
        TextView em = findViewById(R.id.email);
        String email = em.getText().toString();
        TextView psw = findViewById(R.id.password);
        String password = psw.getText().toString();


        if(!email.contains("@")){
            Toast.makeText(MainActivity.this,"Invalid email address!",Toast.LENGTH_SHORT).show();
            return;
        }

        String data = preferences.getString(email,"Not registered!");
        if(!data.equals("Not registered!")){
            Toast.makeText(MainActivity.this,"Email has been registered!",Toast.LENGTH_SHORT).show();
            return;
        }

        if(password.equals("Not registered!") || password.equals("")){
            Toast.makeText(MainActivity.this,"Invalid password!",Toast.LENGTH_SHORT).show();
            return;
        }

        editor.putString(name,email);
        editor.putString(email,password);

        if (editor.commit()){
            Toast.makeText(MainActivity.this,"Register Complete!",Toast.LENGTH_SHORT).show();
        }

        return;
    }

  public void btnLogin(View view){
        TextView em = (TextView)(findViewById(R.id.email));
        String email = em.getText().toString();
        TextView psw = (TextView)(findViewById(R.id.password));
        String password = psw.getText().toString();

        String data = preferences.getString(email,"Not registered!");

        if(!data.equals("Not registered!")){
            if(data.equals(password))
                data = "Sign in successfully!";
            else
                data = "Invalid Credentials!";
        }

        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
    }

}
