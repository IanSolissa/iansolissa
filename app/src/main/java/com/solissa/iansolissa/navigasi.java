package com.solissa.iansolissa;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.solissa.iansolissa.databinding.ActivityNavigasiBinding;



public class navigasi extends AppCompatActivity {
private ImageView gambarcplspls,htmlgambar ,gambarjava ,gambarjs ,gambarphp,cssgambar;
private TextView kontencplspls ,texthtml ,textjava ,textjs ,textphp,textcss;
private com.google.android.material.floatingactionbutton.FloatingActionButton menujuproject;

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavigasiBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        binding = ActivityNavigasiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarNavigasi.toolbar);
        binding.appBarNavigasi.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_IfElse_java, R.id.nav_Switch_java, R.id.nav_functions_JS , R.id.nav_syntax_java , R.id.nav_datatypes_java ,R.id.nav_IfElse_java ,R.id.nav_statements_js , R.id.nav_IfElse_php , R.id.nav_IfElse_JS)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigasi);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        gambarcplspls=findViewById(R.id.cplsplsgambar);
        kontencplspls=findViewById(R.id.cplsplskonten);
htmlgambar=findViewById(R.id.htmlgambar);
texthtml=findViewById(R.id.texthtml);
menujuproject=findViewById(R.id.fab);
gambarjava=findViewById(R.id.gambarjava);
textjava=findViewById(R.id.textjava);
gambarjs=findViewById(R.id.gambarjs);
textjs=findViewById(R.id.textjs);
gambarphp=findViewById(R.id.gambarphp);
textphp=findViewById(R.id.textphp);
cssgambar=findViewById(R.id.cssgambar);
textcss=findViewById(R.id.textCss);
gambarjava=findViewById(R.id.gambarjava);
textjava=findViewById(R.id.textjava);





gambarjava.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent;
        intent=new Intent(navigasi.this , javaAktifity.class);
        startActivity(intent);
    }
});

textjava.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent;
        intent=new Intent(navigasi.this , javaAktifity.class);
        startActivity(intent);
    }
});

menujuproject.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent;
        intent=new Intent(navigasi.this,crud1.class);
        startActivity(intent);
    }
});

gambarjs.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent;
        intent=new Intent(navigasi.this,javascriptAktifity.class);
        startActivity(intent);
    }
});

textjs.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent;
        intent=new Intent(navigasi.this,javascriptAktifity.class);
        startActivity(intent);
    }
});
gambarphp.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent;
        intent = new Intent(navigasi.this,phpaktifity.class);
        startActivity(intent);
    }
});

textphp.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent;
        intent=new Intent(navigasi.this , phpaktifity.class);
        startActivity(intent);
    }
});


cssgambar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent;
        intent =new Intent(navigasi.this , cssAktifity.class);
        startActivity(intent);
    }
});

textcss.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent;
        intent=new Intent(navigasi.this , cssAktifity.class);
        startActivity(intent);
    }
});

        gambarcplspls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(navigasi.this, CplsplsaktifitasActivity.class);
                startActivity(intent);
            }
        });

        htmlgambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                        intent=new Intent(navigasi.this, HTMLlAktifitas.class);
                        startActivity(intent);
            }
        });

        kontencplspls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(navigasi.this, CplsplsaktifitasActivity.class);
                startActivity(intent);
            }
        });

        texthtml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(navigasi.this , HTMLlAktifitas.class);
                startActivity(intent);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigasi, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigasi);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }




}