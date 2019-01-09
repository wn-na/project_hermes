package com.dsml.monjava.deliverycheck;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class LoginActivity
  extends AppCompatActivity
{
  public static String box;
  public static String identity;
  public static String name;
  public static String userid;
  public static String[] vaules;
  private int loginrequestd = 0;
  private long m_exitPressedTime = 0L;
  private String resultvaule;
  private EditText userIDT;
  private String userIDprocess;
  private EditText userPasswordT;
  private String userPasswordprocess;
  
  public void onBackPressed()
  {
    Toast.makeText(this, "뒤로 가기 키를 한번 더 누르시면 종료합니다.", 0).show();
    long l = System.currentTimeMillis();
    if (l - this.m_exitPressedTime <= 1500L)
    {
      finish();
      return;
    }
    this.m_exitPressedTime = l;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131427357);
    this.userIDT = ((EditText)findViewById(2131296511));
    this.userPasswordT = ((EditText)findViewById(2131296512));
    paramBundle = (Button)findViewById(2131296381);
    ((Button)findViewById(2131296429)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(LoginActivity.this, registerActivity.class);
        LoginActivity.this.startActivity(paramAnonymousView);
      }
    });
    paramBundle.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        LoginActivity.access$002(LoginActivity.this, LoginActivity.this.userIDT.getText().toString());
        LoginActivity.access$202(LoginActivity.this, LoginActivity.this.userPasswordT.getText().toString());
        new LoginActivity.JsoupAsyncTaskLogin(LoginActivity.this, null).execute(new Void[0]);
      }
    });
  }
  
  private class JsoupAsyncTaskLogin
    extends AsyncTask<Void, Void, Void>
  {
    private JsoupAsyncTaskLogin() {}
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      try
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("http://osias.asuscomm.com/~post/login_process.php?id=");
        paramVarArgs.append(LoginActivity.this.userIDprocess);
        paramVarArgs.append("&password=");
        paramVarArgs.append(LoginActivity.this.userPasswordprocess);
        paramVarArgs = Jsoup.connect(paramVarArgs.toString()).method(Connection.Method.GET).execute().parse();
        LoginActivity.access$502(LoginActivity.this, paramVarArgs.text());
      }
      catch (IOException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      LoginActivity.vaules = LoginActivity.this.resultvaule.split("/");
      if (LoginActivity.vaules[0].equals("True")) {
        LoginActivity.access$602(LoginActivity.this, 1);
      } else {
        LoginActivity.access$602(LoginActivity.this, 0);
      }
      if (LoginActivity.this.loginrequestd == 1)
      {
        LoginActivity.userid = LoginActivity.this.userIDT.getText().toString();
        LoginActivity.name = LoginActivity.vaules[1];
        LoginActivity.box = LoginActivity.vaules[3];
        if (LoginActivity.vaules[2].equals("1")) {
          LoginActivity.identity = LoginActivity.vaules[4];
        }
        paramVoid = new Intent(LoginActivity.this, MainActivity.class);
        LoginActivity.this.startActivity(paramVoid);
        paramVoid = LoginActivity.this.getApplicationContext();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(LoginActivity.vaules[1]);
        localStringBuilder.append(" 님 환영합니다.");
        Toast.makeText(paramVoid, localStringBuilder.toString(), 0).show();
        LoginActivity.this.finish();
        return;
      }
      if (LoginActivity.this.loginrequestd == 0) {
        new AlertDialog.Builder(LoginActivity.this).setMessage("로그인 정보가 유효하지 않습니다! 다시 시도해주세요.").setNegativeButton("확인", null).create().show();
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
}


/* Location:              C:\dex2jar-2.0\com.dsml.monjava.deliverycheck-dex2jar.jar!\com\dsml\monjava\deliverycheck\LoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */