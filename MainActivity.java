package com.example.clickcountertryout;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView wordPop;
    TextView InfoHealth ;
    Button nukeButton;
    Button laserButton;
    Button shootButton;
    Button rpgButton;
    int sasquash;
    int you;
    int gun;
    int rpg;
    int laser;
    int sasquash2;
    boolean firstSasquash;
    boolean secondSasquash;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wordPop = findViewById(R.id.info);
        InfoHealth = findViewById(R.id.InfoHealth) ;
        nukeButton = findViewById(R.id.nuke);
        laserButton = findViewById(R.id.laser);
        shootButton = findViewById(R.id.shoot) ;
        rpgButton = findViewById(R.id.rPG) ;
        sasquash = 200;
        you = 150;
        gun = 60;
        rpg = 100;
        laser = 150;
        sasquash2 = 49;
        firstSasquash = true;
        secondSasquash = true;
        random = new Random();
        wordPop.setText("A wild Sasquash has appeared!");
        wordPop.append("\n" + "What would you like to do?") ;
        wordPop.append("\n" + "Heads up, you can only use each button only once") ;
        InfoHealth.setText("Sasquash health: " + sasquash) ;
        InfoHealth.append("\n" + "Your health: " + you) ;
        InfoHealth.setTextColor(Color.BLACK);
        InfoHealth.setBackgroundColor(Color.GREEN);
    }

    public void shootingHim(View View) {
        sasquash = sasquash - gun;
        if (sasquash <= 0)  {
            wordPop.setText("\n" + "The Sasquash is dead. You live another day");
            anothermonster();
            if ((sasquash <= 0) && (firstSasquash == false) && (secondSasquash == true)) {
                wordPop.setText("\n" + "The other Sasquash is dead. You're still alive");
                anothermonster();
            } else if ((sasquash <= 0) && (secondSasquash == false)) {
                wordPop.setText("\n" + "The other third one is dead");
                wordPop.append("\n" + "It's astonishing you're still alive");
                anothermonster();
            }
        } else {
            wordPop.append("\n" + "You attacked the Sasquash with a M2 Browning Machine Gun ");
            InfoHealth.setText("Sasquash health: " + sasquash);
            sasquashattack();
            shootButton.setEnabled(false);
        }
    }

    public void rocketinghim (View view) {
        sasquash = sasquash - rpg;
        if (sasquash <= 0) {
            wordPop.setText("\n" + "The Sasquash is dead. You live another day");
            rpgButton.setEnabled(false);
            anothermonster();
            if ((sasquash <= 0) && (firstSasquash == false) && (secondSasquash == true)) {
                wordPop.setText("\n" + "The other Sasquash is dead. You're still alive");
                rpgButton.setEnabled(false);
                anothermonster();
            } else if ((sasquash <= 0) && (secondSasquash == false)) {
                wordPop.setText("\n" + "The other third one is dead");
                wordPop.append("\n" + "It's astonishing you're still alive");
                anothermonster();
            }
        } else {
            wordPop.append("\n" + "You attacked the Sasquash with a RPG");
            InfoHealth.setText("Sasquash health: " + sasquash);
            sasquashattack();
            rpgButton.setEnabled(false);
        }
    }
    public void laser(View view) {
        int laserDamage = random.nextInt(laser) + 5;
        sasquash = sasquash - laserDamage ;
        if (sasquash <= 0) {
            wordPop.setText("\n" +"The Sasquash is dead. You live another day") ;
            laserButton.setEnabled(false);
            anothermonster();
            if ((sasquash <= 0) && (firstSasquash == false) && (secondSasquash == true) ) {
                wordPop.setText("\n" + "The other Sasquash is dead. You're still alive");
                laserButton.setEnabled(false);
                anothermonster();
            } else if ((sasquash <= 0) && (secondSasquash == false)) {
                wordPop.setText("\n" + "The other third one is dead");
                wordPop.append("\n" + "It's astonishing you're still alive");
                anothermonster();
            }
        }
        else {
            wordPop.append("\n" + "You attempted to hit the Sasquash with an intergalactic space weapon");
            InfoHealth.setText("Sasquash health : " + sasquash);
            sasquashattack();
            laserButton.setEnabled(false);
        }
    }

    public void nuke(View view) {
        wordPop.append("\n" +"You killed everyone on the planet. What did you think a nuke would do?");
        wordPop.append("\n" + "Man, you either pushed the button because for one this was your last resort, or two, you saw a button that you wanted to press") ;
        wordPop.append("\n" + "Hey, at least you killed the Sasquash - and yourself") ;
        InfoHealth.setText("Sasquash health: 0") ;
        InfoHealth.append("\n" + "Your health: -200" ) ;
        InfoHealth.setBackgroundColor(Color.BLACK);
        InfoHealth.setTextColor(Color.WHITE);
        nukeButton.setEnabled(false);
        laserButton.setEnabled(false);
        shootButton.setEnabled(false);
        rpgButton.setEnabled(false);
    }
    private void sasquashattack() {
        int sasquashattack = random.nextInt(sasquash2) + 1;
        you = you - sasquashattack;
        if (you<= 0) {
            wordPop.append("\n" + "The Sasquash retaliated!") ;
            wordPop.append("\n" + "The Sasquash slapped the poop out of you") ;
            wordPop.append("\n" + "Perfect - you lost") ;
            wordPop.append("\n" + "Sasquash's now rule the world") ;
            InfoHealth.setText("Sasquash health: Still alive") ;
            InfoHealth.append("\n" + "Your health: Negative health") ;
            InfoHealth.setBackgroundColor(Color.BLACK);
            InfoHealth.setTextColor(Color.WHITE);
            nukeButton.setEnabled(false);
            laserButton.setEnabled(false);
            shootButton.setEnabled(false);
            rpgButton.setEnabled(false);
            if (firstSasquash == false) {
                wordPop.append("\n" + "The Sasquash retaliated!") ;
                wordPop.append("\n" + "The Sasquash punched the poop out of you") ;
                wordPop.append("\n" + "Perfect - you lost") ;
                wordPop.append("\n" + "Sasquash's now rule the world") ;
                InfoHealth.setText("Sasquash health: Still alive") ;
                InfoHealth.append("\n" + "Your health: Negative health") ;
                InfoHealth.setBackgroundColor(Color.BLACK);
                InfoHealth.setTextColor(Color.WHITE);
                nukeButton.setEnabled(false);
                laserButton.setEnabled(false);
                shootButton.setEnabled(false);
                rpgButton.setEnabled(false);
            } else if (secondSasquash == false) {
                wordPop.append("\n" + "The Sasquash retaliated!") ;
                wordPop.append("\n" + "The Sasquash kicked the poop out of you") ;
                wordPop.append("\n" + "Perfect - you lost") ;
                wordPop.append("\n" + "Sasquash's now rule the world") ;
                InfoHealth.setText("Sasquash health: Still alive") ;
                InfoHealth.append("\n" + "Your health: Negative health") ;
                InfoHealth.setBackgroundColor(Color.BLACK);
                InfoHealth.setTextColor(Color.WHITE);
                nukeButton.setEnabled(false);
                laserButton.setEnabled(false);
                shootButton.setEnabled(false);
                rpgButton.setEnabled(false);
            }
        }
        else {
            wordPop.append("\n" + "The Sasquash retaliated!");
            wordPop.append("\n" + "He slapped you across the face. Ouch!");
            wordPop.append("\n" + "What would you like to do next?");
            if ((firstSasquash == false) && (you > 0) && (you <= 50)) {
                InfoHealth.setBackgroundColor(Color.RED);
                InfoHealth.setTextColor(Color.BLACK);
                InfoHealth.append("\n" + "Your health: " + you);
            } else if ((firstSasquash == false) && (you >= 51) && (you <= 150)) {
                InfoHealth.setBackgroundColor(Color.YELLOW);
                InfoHealth.setTextColor(Color.BLACK);
                InfoHealth.append("\n" + "Your health: " + you);
            } else if ((firstSasquash == false) && (you >= 151) && (you <= 300)) {
                InfoHealth.setBackgroundColor(Color.GREEN);
                InfoHealth.setTextColor(Color.BLACK);
                InfoHealth.append("\n" + "Your health: " + you);
            } else if ((firstSasquash == true) && (you >= 0) && (you <= 50)) {
                InfoHealth.setBackgroundColor(Color.RED);
                InfoHealth.setTextColor(Color.BLACK);
                InfoHealth.append("\n" + "Your health: " + you);
            } else if ((firstSasquash == true) && (you >= 51) && (you <= 70)) {
                InfoHealth.setBackgroundColor(Color.YELLOW);
                InfoHealth.setTextColor(Color.BLACK);
                InfoHealth.append("\n" + "Your health: " + you);
            } else if ((firstSasquash == true) && (you >= 71) && (you <= 150)) {
                InfoHealth.setBackgroundColor(Color.YELLOW);
                InfoHealth.setTextColor(Color.BLACK);
                InfoHealth.append("\n" + "Your health: " + you);
            } else if ((secondSasquash == false) && (you >= 0) && (you <= 200)) {
                InfoHealth.setBackgroundColor(Color.RED);
                InfoHealth.setTextColor(Color.BLACK);
                InfoHealth.append("\n" + "Your health: " + you);
            } else if ((secondSasquash == false) && (you >= 201) && (you <= 400)) {
                InfoHealth.setBackgroundColor(Color.YELLOW);
                InfoHealth.setTextColor(Color.BLACK);
                InfoHealth.append("\n" + "Your health: " + you);
            } else if ((secondSasquash == false) && (you >= 401) && (you <= 600)) {
                InfoHealth.setBackgroundColor(Color.YELLOW);
                InfoHealth.setTextColor(Color.BLACK);
                InfoHealth.append("\n" + "Your health: " + you);
            }
        }

    }
    public void startover (View view) {
        sasquash = 200;
        you = 150;
        gun = 60;
        rpg = 100;
        laser = 150;
        sasquash2 = 151;
        nukeButton.setEnabled(true);
        laserButton.setEnabled(true);
        shootButton.setEnabled(true);
        rpgButton.setEnabled(true);
        wordPop.setText("A wild Sasquash has appeared!");
        wordPop.append("\n" + "What would you like to do?");
        wordPop.append("\n" + "Heads up, you can only use each button only once") ;
        InfoHealth.setText("Sasquash health: " + sasquash) ;
        InfoHealth.append("\n" + "Your health: " + you) ;
        InfoHealth.setTextColor(Color.BLACK);
        InfoHealth.setBackgroundColor(Color.GREEN);
        firstSasquash = true;
    }
    private void anothermonster() {
        if (firstSasquash) {

            sasquash = 200 *2;
            you = 150 * 2;
            nukeButton.setEnabled(true);
            laserButton.setEnabled(true);
            shootButton.setEnabled(true);
            rpgButton.setEnabled(true);
            wordPop.append("\n" + "Hey, another Sasquash popped up! It's his buddy!");
            wordPop.append("\n" + "What would you like to do?");
            InfoHealth.setText("Sasquash health 2nd Round: " + sasquash);
            InfoHealth.append("\n" + "Your health 2nd Round: " + you);
            gun = gun * 2;
            rpg = rpg * 2;
            laser = laser * 2;
            sasquash2 = sasquash2 * 2;
            firstSasquash = false;
            InfoHealth.setTextColor(Color.BLACK);
            InfoHealth.setBackgroundColor(Color.GREEN);
        }
        else if (secondSasquash){
            sasquash = 200 *4;
            you = 150 * 4;
            nukeButton.setEnabled(true);
            laserButton.setEnabled(true);
            shootButton.setEnabled(true);
            rpgButton.setEnabled(true);
            wordPop.append("\n" + "Wait, there's a third one? Where do they come from?");
            wordPop.append("\n" + "What would you like to do?");
            InfoHealth.setText("Sasquash health 3rd Round: " + sasquash);
            InfoHealth.append("\n" + "Your health 3rd Round: " + you);
            gun = gun * 4;
            rpg = rpg * 4;
            laser = laser * 4;
            sasquash2 = sasquash2 * 3;
            secondSasquash = false;
            InfoHealth.setTextColor(Color.BLACK);
            InfoHealth.setBackgroundColor(Color.GREEN);
        } else {
            wordPop.append("\n" + "You have destroyed three innocent sasquahes - why?");
            wordPop.append("\n" + "But hey, you're still alive - congratulations, you won!");
            laserButton.setEnabled(false);
            shootButton.setEnabled(false);
            rpgButton.setEnabled(false) ;
            nukeButton.setEnabled(false) ;
            InfoHealth.setTextColor(Color.BLACK);
            InfoHealth.setBackgroundColor(Color.WHITE);
            InfoHealth.setText("Sasquash health: " + 0) ;
            InfoHealth.append("\n" + "Your health: " + you) ;
        }
    }
}

