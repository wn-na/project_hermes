package com.dsml.monjava.deliverycheck;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MainActivity
  extends AppCompatActivity
  implements NavigationView.OnNavigationItemSelectedListener
{
  private long m_exitPressedTime = 0L;
  private int opened = 0;
  private String resultd;
  long start;
  boolean threemin = false;
  
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
    setContentView(2131427358);
    Object localObject = (Toolbar)findViewById(2131296499);
    setSupportActionBar((Toolbar)localObject);
    paramBundle = (DrawerLayout)findViewById(2131296331);
    localObject = new ActionBarDrawerToggle(this, paramBundle, (Toolbar)localObject, 2131623984, 2131623983);
    paramBundle.addDrawerListener((DrawerLayout.DrawerListener)localObject);
    ((ActionBarDrawerToggle)localObject).syncState();
    ((NavigationView)findViewById(2131296394)).setNavigationItemSelectedListener(this);
    getSupportFragmentManager().beginTransaction().replace(2131296348, new fragmentmain()).commit();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131492865, paramMenu);
    return true;
  }
  
  public boolean onNavigationItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i == 2131296480) {
      getSupportFragmentManager().beginTransaction().replace(2131296348, new fragmentstreaming()).commit();
    } else if (i == 2131296391) {
      getSupportFragmentManager().beginTransaction().replace(2131296348, new fragmentinfo()).commit();
    } else if (i == 2131296259)
    {
      if (LoginActivity.vaules[2].equals("1")) {
        getSupportFragmentManager().beginTransaction().replace(2131296348, new fragmentDelivermenu()).commit();
      } else {
        Toast.makeText(this, "택배 기사 전용 메뉴입니다. 접근 권한이 없습니다.", 1).show();
      }
    }
    else if (i == 2131296393) {
      Toast.makeText(this, "아직 개발되지 않은 기능입니다! 차후 추가예정입니다!", 1).show();
    } else if (i == 2131296392)
    {
      if (this.opened == 0)
      {
        new JsoupAsyncTaskopen(null).execute(new Void[0]);
        this.opened = 1;
        new ExampleThread(System.currentTimeMillis()).start();
      }
      else
      {
        Toast.makeText(this, "이미 열려있습니다.", 1).show();
      }
    }
    else if (i == 2131296384) {
      getSupportFragmentManager().beginTransaction().replace(2131296348, new fragmentmain()).commit();
    } else if (i == 2131296313) {
      if (this.opened == 1)
      {
        new JsoupAsyncTaskclose(null).execute(new Void[0]);
        this.opened = 0;
      }
      else
      {
        Toast.makeText(this, "이미 닫혀있습니다.", 1).show();
      }
    }
    ((DrawerLayout)findViewById(2131296331)).closeDrawer(8388611);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131296282)
    {
      startActivity(new Intent(getApplicationContext(), LoginActivity.class));
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  private class ExampleThread
    extends Thread
  {
    private long start;
    
    public ExampleThread(long paramLong)
    {
      this.start = paramLong;
    }
    
    public void run()
    {
      while (MainActivity.this.opened == 1) {
        if (System.currentTimeMillis() - this.start > 30000L)
        {
          MainActivity.this.threemin = true;
          new MainActivity.JsoupAsyncTaskclose(MainActivity.this, null).execute(new Void[0]);
          MainActivity.access$002(MainActivity.this, 0);
        }
      }
    }
  }
  
  private class JsoupAsyncTaskclose
    extends AsyncTask<Void, Void, Void>
  {
    private JsoupAsyncTaskclose() {}
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      try
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("http://osias.asuscomm.com/~post/changeclose.php?BOXnumb=");
        paramVarArgs.append(LoginActivity.vaules[3]);
        paramVarArgs = Jsoup.connect(paramVarArgs.toString()).method(Connection.Method.GET).execute().parse();
        MainActivity.access$302(MainActivity.this, paramVarArgs.text());
      }
      catch (IOException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      if (MainActivity.this.resultd.equals("True/"))
      {
        if (MainActivity.this.threemin == true)
        {
          Toast.makeText(MainActivity.this.getApplicationContext(), "3분이 지나 보관함을 자동으로 닫습니다.", 1).show();
          MainActivity.this.threemin = false;
          return;
        }
        Toast.makeText(MainActivity.this.getApplicationContext(), "보관함을 닫습니다.", 1).show();
        return;
      }
      Toast.makeText(MainActivity.this.getApplicationContext(), "에러가 발생했습니다. 잠시후에 다시 시도해 주세요", 1).show();
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
  
  private class JsoupAsyncTaskopen
    extends AsyncTask<Void, Void, Void>
  {
    private JsoupAsyncTaskopen() {}
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      try
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("http://osias.asuscomm.com/~post/changeopenuser.php?BOXnumb=");
        paramVarArgs.append(LoginActivity.vaules[3]);
        paramVarArgs.append("&usercode=");
        paramVarArgs.append(LoginActivity.userid);
        paramVarArgs = Jsoup.connect(paramVarArgs.toString()).method(Connection.Method.GET).execute().parse();
        MainActivity.access$302(MainActivity.this, paramVarArgs.text());
      }
      catch (IOException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      if (MainActivity.this.resultd.equals("True/"))
      {
        Toast.makeText(MainActivity.this.getApplicationContext(), "보관함을 오픈합니다. 3분뒤에 자동으로 닫힙니다!", 1).show();
        return;
      }
      Toast.makeText(MainActivity.this.getApplicationContext(), "에러가 발생했습니다. 잠시후에 다시 시도해 주세요", 1).show();
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
}


/* Location:              C:\dex2jar-2.0\com.dsml.monjava.deliverycheck-dex2jar.jar!\com\dsml\monjava\deliverycheck\MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */