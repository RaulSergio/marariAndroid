package ucdb.br.sweccamobile;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    private TextView txtApres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        txtApres = (TextView) findViewById(R.id.txtApres);
        Animation myAnim = AnimationUtils.loadAnimation(this,R.anim.transition_logo);
        txtApres.startAnimation(myAnim);

        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarHome();
            }
        }, 4000);

    }

    private void mostrarHome() {
        Intent it = new Intent(SplashScreen.this, TelaLogin.class);
        startActivity(it);
        finish();
    }

}
