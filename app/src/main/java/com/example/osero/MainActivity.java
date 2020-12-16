package com.example.osero;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageButton[][] rectButtons = new ImageButton[8][8];
    private int[][] button_flag = new int[8][8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rectButtons[0][0] = (ImageButton) findViewById(R.id.no00);
        rectButtons[0][1] = (ImageButton) findViewById(R.id.no01);
        rectButtons[0][2] = (ImageButton) findViewById(R.id.no02);
        rectButtons[0][3] = (ImageButton) findViewById(R.id.no03);
        rectButtons[0][4] = (ImageButton) findViewById(R.id.no04);
        rectButtons[0][5] = (ImageButton) findViewById(R.id.no05);
        rectButtons[0][6] = (ImageButton) findViewById(R.id.no06);
        rectButtons[0][7] = (ImageButton) findViewById(R.id.no07);
        rectButtons[1][0] = (ImageButton) findViewById(R.id.no10);
        rectButtons[1][1] = (ImageButton) findViewById(R.id.no11);
        rectButtons[1][2] = (ImageButton) findViewById(R.id.no12);
        rectButtons[1][3] = (ImageButton) findViewById(R.id.no13);
        rectButtons[1][4] = (ImageButton) findViewById(R.id.no14);
        rectButtons[1][5] = (ImageButton) findViewById(R.id.no15);
        rectButtons[1][6] = (ImageButton) findViewById(R.id.no16);
        rectButtons[1][7] = (ImageButton) findViewById(R.id.no17);
        rectButtons[2][0] = (ImageButton) findViewById(R.id.no20);
        rectButtons[2][1] = (ImageButton) findViewById(R.id.no21);
        rectButtons[2][2] = (ImageButton) findViewById(R.id.no22);
        rectButtons[2][3] = (ImageButton) findViewById(R.id.no23);
        rectButtons[2][4] = (ImageButton) findViewById(R.id.no24);
        rectButtons[2][5] = (ImageButton) findViewById(R.id.no25);
        rectButtons[2][6] = (ImageButton) findViewById(R.id.no26);
        rectButtons[2][7] = (ImageButton) findViewById(R.id.no27);
        rectButtons[3][0] = (ImageButton) findViewById(R.id.no30);
        rectButtons[3][1] = (ImageButton) findViewById(R.id.no31);
        rectButtons[3][2] = (ImageButton) findViewById(R.id.no32);
        rectButtons[3][3] = (ImageButton) findViewById(R.id.no33);
        rectButtons[3][4] = (ImageButton) findViewById(R.id.no34);
        rectButtons[3][5] = (ImageButton) findViewById(R.id.no35);
        rectButtons[3][6] = (ImageButton) findViewById(R.id.no36);
        rectButtons[3][7] = (ImageButton) findViewById(R.id.no37);
        rectButtons[4][0] = (ImageButton) findViewById(R.id.no40);
        rectButtons[4][1] = (ImageButton) findViewById(R.id.no41);
        rectButtons[4][2] = (ImageButton) findViewById(R.id.no42);
        rectButtons[4][3] = (ImageButton) findViewById(R.id.no43);
        rectButtons[4][4] = (ImageButton) findViewById(R.id.no44);
        rectButtons[4][5] = (ImageButton) findViewById(R.id.no45);
        rectButtons[4][6] = (ImageButton) findViewById(R.id.no46);
        rectButtons[4][7] = (ImageButton) findViewById(R.id.no47);
        rectButtons[5][0] = (ImageButton) findViewById(R.id.no50);
        rectButtons[5][1] = (ImageButton) findViewById(R.id.no51);
        rectButtons[5][2] = (ImageButton) findViewById(R.id.no52);
        rectButtons[5][3] = (ImageButton) findViewById(R.id.no53);
        rectButtons[5][4] = (ImageButton) findViewById(R.id.no54);
        rectButtons[5][5] = (ImageButton) findViewById(R.id.no55);
        rectButtons[5][6] = (ImageButton) findViewById(R.id.no56);
        rectButtons[5][7] = (ImageButton) findViewById(R.id.no57);
        rectButtons[6][0] = (ImageButton) findViewById(R.id.no60);
        rectButtons[6][1] = (ImageButton) findViewById(R.id.no61);
        rectButtons[6][2] = (ImageButton) findViewById(R.id.no62);
        rectButtons[6][3] = (ImageButton) findViewById(R.id.no63);
        rectButtons[6][4] = (ImageButton) findViewById(R.id.no64);
        rectButtons[6][5] = (ImageButton) findViewById(R.id.no65);
        rectButtons[6][6] = (ImageButton) findViewById(R.id.no66);
        rectButtons[6][7] = (ImageButton) findViewById(R.id.no67);
        rectButtons[7][0] = (ImageButton) findViewById(R.id.no70);
        rectButtons[7][1] = (ImageButton) findViewById(R.id.no71);
        rectButtons[7][2] = (ImageButton) findViewById(R.id.no72);
        rectButtons[7][3] = (ImageButton) findViewById(R.id.no73);
        rectButtons[7][4] = (ImageButton) findViewById(R.id.no74);
        rectButtons[7][5] = (ImageButton) findViewById(R.id.no75);
        rectButtons[7][6] = (ImageButton) findViewById(R.id.no76);
        rectButtons[7][7] = (ImageButton) findViewById(R.id.no77);

        resetGame();
        ex_put(1);
    }

    //リセットするメソッド
    private void resetGame() {
        for (int i=0; i<8; i++) {
            for (int j=0;j<8; j++) {
                rectButtons[i][j].setBackgroundResource(R.drawable.none);
                button_flag[i][j] = 0;
            }
        }
        rectButtons[3][3].setBackgroundResource(R.drawable.kuro);
        rectButtons[4][4].setBackgroundResource(R.drawable.kuro);
        rectButtons[3][4].setBackgroundResource(R.drawable.siro);
        rectButtons[4][3].setBackgroundResource(R.drawable.siro);

        //黒:1 白:2
        button_flag[3][3] = 1;
        button_flag[4][4] = 1;
        button_flag[3][4] = 2;
        button_flag[4][3] = 2;
    }

    //put画像セットメソッド
    private void  set(int i, int j, int first){
        if (first==1) {
            rectButtons[i][j].setBackgroundResource(R.drawable.put);
            button_flag[i][j] = 3;//黒コマが置ける場所
        }else{
            rectButtons[i][j].setBackgroundResource(R.drawable.put);
            button_flag[i][j] = 4;//黒コマが置ける場所
        }
    }

    //画像セットメソッド
    private void  rever(int i, int j,int senkou){
        if (senkou==1) {
            rectButtons[i][j].setBackgroundResource(R.drawable.kuro);
            button_flag[i][j] = 1;
        }else{
            rectButtons[i][j].setBackgroundResource(R.drawable.siro);
            button_flag[i][j] = 2;
        }
    }

    //putメソッド
    private void put(int yoko, int tate, int v, int y){
        int flag=0;
        if (y==1){
            if (v==1) {
                for (int x = 0; yoko != 0 && tate != 0 && flag != 1; x++) {//左斜上検索
                    yoko = yoko - 1;
                    tate = tate - 1;
                    if (button_flag[yoko][tate] == 1) {//黒の場合(黒ゴマ検索に行く)
                        flag = 1;
                    } else if (button_flag[yoko][tate] != 1 && button_flag[yoko][tate] != 2) {//何もない場合(1週目:黒ゴマ検索に行)(2週目以降:put画像配置)
                        if (x == 0) {//1週目
                            flag = 1;
                        } else {//2週目
                            set(yoko, tate, 1);
                            flag = 1;
                        }
                    }//白の場合何もしない
                }
            }else if (v==2){
                for (int x=0;tate!=0&&flag!=1; x++) {//上検索
                    tate=tate-1;
                    if (button_flag[yoko][tate] == 1) {//黒の場合(黒ゴマ検索に行く)
                        flag = 1;
                    } else if (button_flag[yoko][tate] != 1 && button_flag[yoko][tate] != 2) {//何もない場合(1週目:黒ゴマ検索に行)(2週目以降:put画像配置)
                        if (x == 0) {//1週目
                            flag = 1;
                        } else {//2週目
                            set(yoko,tate,1);
                            flag=1;
                        }
                    }//白の場合何もしない
                }
            }else if (v==3){
                for (int x=0;yoko!=7&&tate!=7&&flag!=1; x++) {//右斜上検索
                    yoko=yoko+1;
                    tate=tate-1;
                    if (button_flag[yoko][tate] == 1) {//黒の場合(黒ゴマ検索に行く)
                        flag = 1;
                    } else if (button_flag[yoko][tate] != 1 && button_flag[yoko][tate] != 2) {//何もない場合(1週目:黒ゴマ検索に行)(2週目以降:put画像配置)
                        if (x == 0) {//1週目
                            flag = 1;
                        } else {//2週目
                            set(yoko,tate,1);
                            flag=1;
                        }
                    }//白の場合何もしない
                }
            }else if (v==4){
                for (int x=0;yoko!=7&&flag!=1; x++) {//右検索
                    yoko=yoko+1;
                    if (button_flag[yoko][tate] == 1) {//黒の場合(黒ゴマ検索に行く)
                        flag = 1;
                    } else if (button_flag[yoko][tate] != 1 && button_flag[yoko][tate] != 2) {//何もない場合(1週目:黒ゴマ検索に行)(2週目以降:put画像配置)
                        if (x == 0) {//1週目
                            flag = 1;
                        } else {//2週目
                            set(yoko,tate,1);
                            flag=1;
                        }
                    }//白の場合何もしない
                }
            }else if (v==5){
                for (int x=0;yoko!=7&&tate!=7&&flag!=1; x++) {//右下検索
                    yoko=yoko+1;
                    tate = tate +1;
                    if (button_flag[yoko][tate] == 1) {//黒の場合(黒ゴマ検索に行く)
                        flag = 1;
                    } else if (button_flag[yoko][tate] != 1 && button_flag[yoko][tate] != 2) {//何もない場合(1週目:黒ゴマ検索に行)(2週目以降:put画像配置)
                        if (x == 0) {//1週目
                            flag = 1;
                        } else {//2週目
                            set(yoko,tate,1);
                            flag=1;
                        }
                    }//白の場合何もしない
                }
            }else if (v==6){
                for (int x=0;tate!=7&&flag!=1; x++) {//下検索
                    tate=tate+1;
                    if (button_flag[yoko][tate] == 1) {//黒の場合(黒ゴマ検索に行く)
                        flag = 1;
                    } else if (button_flag[yoko][tate] != 1 && button_flag[yoko][tate] != 2) {//何もない場合(1週目:黒ゴマ検索に行)(2週目以降:put画像配置)
                        if (x == 0) {//1週目
                            flag = 1;
                        } else {//2週目
                            set(yoko,tate,1);
                            flag=1;
                        }
                    }//白の場合何もしない
                }
            }else if (v==7){
                for (int x=0;yoko!=0&&tate!=7&&flag!=1; x++) {//左下検索
                    yoko=yoko-1;
                    tate = tate+1;
                    if (button_flag[yoko][tate] == 1) {//黒の場合(黒ゴマ検索に行く)
                        flag = 1;
                    } else if (button_flag[yoko][tate] != 1 && button_flag[yoko][tate] != 2) {//何もない場合(1週目:黒ゴマ検索に行)(2週目以降:put画像配置)
                        if (x == 0) {//1週目
                            flag = 1;
                        } else {//2週目
                            set(yoko,tate,1);
                            flag=1;
                        }
                    }//白の場合何もしない
                }
            }else if (v==8){
                for (int x=0;yoko!=0&&flag!=1; x++) {//左検索
                    yoko=yoko-1;
                    if (button_flag[yoko][tate] == 1) {//黒の場合(黒ゴマ検索に行く)
                        flag = 1;
                    } else if (button_flag[yoko][tate] != 1 && button_flag[yoko][tate] != 2) {//何もない場合(1週目:黒ゴマ検索に行)(2週目以降:put画像配置)
                        if (x == 0) {//1週目
                            flag = 1;
                        } else {//2週目
                            set(yoko,tate,1);
                            flag=1;
                        }
                    }//白の場合何もしない
                }
            }
        }else{
            if (v==1){
                for (int x=0;yoko!=0&&tate!=0&&flag!=1; x++) {//左斜上検索
                    yoko =yoko-1;
                    tate=tate-1;
                    if (button_flag[yoko][tate] == 2) {//黒の場合(黒ゴマ検索に行く)
                        flag = 1;
                    } else if (button_flag[yoko][tate] != 1 && button_flag[yoko][tate] != 2) {//何もない場合(1週目:黒ゴマ検索に行)(2週目以降:put画像配置)
                        if (x == 0) {//1週目
                            flag = 1;
                        } else {//2週目
                            set(yoko,tate,2);
                            flag=1;
                        }
                    }//白の場合何もしない
                }
            }else if (v==2){
                for (int x=0;tate!=0&&flag!=1; x++) {//上検索
                    tate=tate-1;
                    if (button_flag[yoko][tate] == 2) {//黒の場合(黒ゴマ検索に行く)
                        flag = 1;
                    } else if (button_flag[yoko][tate] != 1 && button_flag[yoko][tate] != 2) {//何もない場合(1週目:黒ゴマ検索に行)(2週目以降:put画像配置)
                        if (x == 0) {//1週目
                            flag = 1;
                        } else {//2週目
                            set(yoko,tate,2);
                            flag=1;
                        }
                    }//白の場合何もしない
                }
            }else if (v==3){
                for (int x=0;yoko!=7&&tate!=7&&flag!=1; x++) {//右斜上検索
                    yoko=yoko+1;
                    tate=tate-1;
                    if (button_flag[yoko][tate] == 2) {//黒の場合(黒ゴマ検索に行く)
                        flag = 1;
                    } else if (button_flag[yoko][tate] != 1 && button_flag[yoko][tate] != 2) {//何もない場合(1週目:黒ゴマ検索に行)(2週目以降:put画像配置)
                        if (x == 0) {//1週目
                            flag = 1;
                        } else {//2週目
                            set(yoko,tate,2);
                            flag=1;
                        }
                    }//白の場合何もしない
                }
            }else if (v==4){
                for (int x=0;yoko!=7&&flag!=1; x++) {//右検索
                    yoko=yoko+1;
                    if (button_flag[yoko][tate] == 2) {//黒の場合(黒ゴマ検索に行く)
                        flag = 1;
                    } else if (button_flag[yoko][tate] != 1 && button_flag[yoko][tate] != 2) {//何もない場合(1週目:黒ゴマ検索に行)(2週目以降:put画像配置)
                        if (x == 0) {//1週目
                            flag = 1;
                        } else {//2週目
                            set(yoko,tate,2);
                            flag=1;
                        }
                    }//白の場合何もしない
                }
            }else if (v==5){
                for (int x=0;yoko!=7&&tate!=7&&flag!=1; x++) {//右下検索
                    yoko=yoko+1;
                    tate = tate +1;
                    if (button_flag[yoko][tate] == 2) {//黒の場合(黒ゴマ検索に行く)
                        flag = 1;
                    } else if (button_flag[yoko][tate] != 1 && button_flag[yoko][tate] != 2) {//何もない場合(1週目:黒ゴマ検索に行)(2週目以降:put画像配置)
                        if (x == 0) {//1週目
                            flag = 1;
                        } else {//2週目
                            set(yoko,tate,2);
                            flag=1;
                        }
                    }//白の場合何もしない
                }
            }else if (v==6){
                for (int x=0;tate!=7&&flag!=1; x++) {//下検索
                    tate=tate+1;
                    if (button_flag[yoko][tate] == 2) {//黒の場合(黒ゴマ検索に行く)
                        flag = 1;
                    } else if (button_flag[yoko][tate] != 1 && button_flag[yoko][tate] != 2) {//何もない場合(1週目:黒ゴマ検索に行)(2週目以降:put画像配置)
                        if (x == 0) {//1週目
                            flag = 1;
                        } else {//2週目
                            set(yoko,tate,2);
                            flag=1;
                        }
                    }//白の場合何もしない
                }
            }else if (v==7){
                for (int x=0;yoko!=0&&tate!=7&&flag!=1; x++) {//左下検索
                    yoko=yoko-1;
                    tate = tate+1;
                    if (button_flag[yoko][tate] == 2) {//黒の場合(黒ゴマ検索に行く)
                        flag = 1;
                    } else if (button_flag[yoko][tate] != 1 && button_flag[yoko][tate] != 2) {//何もない場合(1週目:黒ゴマ検索に行)(2週目以降:put画像配置)
                        if (x == 0) {//1週目
                            flag = 1;
                        } else {//2週目
                            set(yoko,tate,2);
                            flag=1;
                        }
                    }//白の場合何もしない
                }
            }else if (v==8){
                for (int x=0;yoko!=0&&flag!=1; x++) {//左検索
                    yoko=yoko-1;
                    if (button_flag[yoko][tate] == 2) {//黒の場合(黒ゴマ検索に行く)
                        flag = 1;
                    } else if (button_flag[yoko][tate] != 1 && button_flag[yoko][tate] != 2) {//何もない場合(1週目:黒ゴマ検索に行)(2週目以降:put画像配置)
                        if (x == 0) {//1週目
                            flag = 1;
                        } else {//2週目
                            set(yoko,tate,2);
                            flag=1;
                        }
                    }//白の場合何もしない
                }
            }
        }
    }

    //put画像をいれるメソッド
    private void ex_put(int first) {
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                if (button_flag[i][j] == 3 || button_flag[i][j] == 4){
                    rectButtons[i][j].setBackgroundResource(R.drawable.none);
                    button_flag[i][j]=0;
                }
            }
        }
        //先行かどうか判断
        if (first==1){
            //黒ゴマを探す
            for (int i=0; i<8; i++){
                for (int j=0; j<8; j++){
                    if (button_flag[i][j]==1) {//黒ゴマがあった場合
                        if ((i>=2&&i<=5)&&(j>=2&&j<=5)) {//8方向検索
                            put(i,j,1,1);//左上
                            put(i,j,2,1);//上
                            put(i,j,3,1);//右上
                            put(i,j,4,1);//右
                            put(i,j,5,1);//右下
                            put(i,j,6,1);//下
                            put(i,j,7,1);//左下
                            put(i,j,8,1);//左
                        }
                        if ((i==1&&(j>=1||j<=6))||(i==6&&(j>=1||j<=6))||(j==1&&(i>=1||i<=6))||(j==6&&(i>=1||i<=6))) {   //外枠から2番目
                            if (i == 1 && j == 1) {//右、斜右下、下
                                put(i,j,4,1);//右
                                put(i,j,5,1);//右下
                                put(i,j,6,1);//下
                            }
                            if (i == 1 && (j >= 2 && j <= 5)) {    //右、斜右下、下、右斜上、上
                                put(i,j,4,1);//右
                                put(i,j,5,1);//右下
                                put(i,j,6,1);//下
                                put(i,j,3,1);//右上
                                put(i,j,2,1);//上
                            }
                            if (i == 1 && j == 6) {    //右、斜右上、上
                                put(i,j,4,1);//右
                                put(i,j,3,1);//右上
                                put(i,j,2,1);//上
                            }
                            if (j == 1 && (i >= 2 && i <= 5)) {    //右、左斜下、下、右斜下、左
                                put(i,j,4,1);//右
                                put(i,j,5,1);//右下
                                put(i,j,7,1);//左下
                                put(i,j,6,1);//下
                                put(i,j,8,1);//左
                            }
                            if (i == 6 && j == 1) {    //左、斜左下、下
                                put(i,j,8,1);//左
                                put(i,j,7,1);//左下
                                put(i,j,6,1);//下
                            }
                            if (i == 6 && (j >= 2 && j <= 5)) {    //上、左斜下、下、左斜上、左
                                put(i,j,2,1);//上
                                put(i,j,7,1);//左下
                                put(i,j,6,1);//下
                                put(i,j,1,1);//左上
                                put(i,j,8,1);//左
                            }
                            if ((i == 6 && j == 6)) {    //左、斜左上、上
                                put(i,j,8,1);//左
                                put(i,j,1,1);//左上
                                put(i,j,2,1);//上
                            }
                            if (j == 6 && (i >= 2 && i <= 5)) {    //上、左斜上、右、右斜上、左
                                put(i,j,2,1);//上
                                put(i,j,1,1);//左上
                                put(i,j,4,1);//右
                                put(i,j,3,1);//右上
                                put(i,j,8,1);//左
                            }
                        }
                        if ((i==0&&(j>=0||j<=7))||(i==7&&(j>=0||j<=7))||(j==0&&(i>=0||i<=7))||(j==7&&(i>=0||j<=7))){//外枠の場合
                            if ((i == 0 && j == 1) || (i == 1 && j == 0) || (i == 0 && j == 0)){//右、下、斜右下
                                put(i,j,4,1);//右
                                put(i,j,6,1);//下
                                put(i,j,5,1);//右下
                            }
                            if ((i == 7 && j == 1) || (i == 6 && j == 0) || (i == 7 && j == 0)){//左、左斜下、下
                                put(i,j,8,1);//左
                                put(i,j,6,1);//下
                                put(i,j,7,1);//左下
                            }
                            if ((i == 7 && j == 6) || (i == 6 && j == 7) || (i == 7 && j == 7)){//上、斜左上、左
                                put(i,j,1,1);//左上
                                put(i,j,8,1);//左
                                put(i,j,2,1);//上
                            }
                            if ((i == 0 && j == 6) || (i == 1 && j == 7) || (i == 0 && j == 7)){//上、右斜上、右
                                put(i,j,2,1);//上
                                put(i,j,3,1);//右上
                                put(i,j,4,1);//右
                            }
                            if (j == 0 && (i >=2 && i <=5)){//右、左、下、右下、左下
                                put(i,j,5,1);//右下
                                put(i,j,4,1);//右
                                put(i,j,8,1);//左
                                put(i,j,6,1);//下
                                put(i,j,7,1);//左下
                            }
                            if (i == 7 && (j >=2 && j <=5)){//上、下、左、左上、左下、
                                put(i,j,1,1);//左上
                                put(i,j,2,1);//上
                                put(i,j,6,1);//下
                                put(i,j,7,1);//左下
                                put(i,j,8,1);//左
                            }
                            if (j == 7 && (i >=2 && i <=5)){//上、右、左、右上、左上
                                put(i,j,1,1);//左上
                                put(i,j,3,1);//右上
                                put(i,j,4,1);//右
                                put(i,j,2,1);//上
                                put(i,j,8,1);//左
                            }
                            if (i == 0 && (j >=2 && j <=5)){//上、右、右上、右下、下
                                put(i,j,5,1);//右下
                                put(i,j,3,1);//右上
                                put(i,j,4,1);//右
                                put(i,j,2,1);//上
                                put(i,j,6,1);//下
                            }
                        }
                    }
                }
            }
        }else{  //白の場合
            //白ゴマを探す
            for (int i=0; i<8; i++){
                for (int j=0; j<8; j++){
                    if (button_flag[i][j]==2) {//黒ゴマがあった場合
                        if ((i>=2&&i<=5)&&(j>=2&&j<=5)) {//8方向検索
                            put(i,j,1,2);//左上
                            put(i,j,2,2);//上
                            put(i,j,3,2);//右上
                            put(i,j,4,2);//右
                            put(i,j,5,2);//右下
                            put(i,j,6,2);//下
                            put(i,j,7,2);//左下
                            put(i,j,8,2);//左
                        }
                        if ((i==1&&(j>=1||j<=6))||(i==6&&(j>=1||j<=6))||(j==1&&(i>=1||i<=6))||(j==6&&(i>=1||i<=6))) {   //外枠から2番目
                            if (i == 1 && j == 1) {//右、斜右下、下
                                put(i, j, 4, 2);//右
                                put(i, j, 6, 2);//下
                                put(i, j, 5, 2);//右下
                            }
                            if (i == 1 && (j >= 2 && j <= 5)) {    //右、斜右下、下、右斜上、上
                                put(i, j, 3, 2);//右上
                                put(i, j, 6, 2);//下
                                put(i, j, 4, 2);//右
                                put(i, j, 5, 2);//右下
                                put(i, j, 2, 2);//上
                            }
                            if (i == 1 && j == 6) {    //右、斜右上、上
                                put(i, j, 4, 2);//右
                                put(i, j, 2, 2);//上
                                put(i, j, 3, 2);//右上
                            }
                            if (j == 1 && (i >= 2 && i <= 5)) {    //右、左斜下、下、右斜下、左
                                put(i,j,5,2);//右下
                                put(i,j,6,2);//下
                                put(i,j,4,2);//右
                                put(i,j,7,2);//左下
                                put(i,j,8,2);//左
                            }
                            if (i == 6 && j == 1) {    //左、斜左下、下
                                put(i, j, 7, 2);//左下
                                put(i, j, 6, 2);//下
                                put(i, j, 8, 2);//左
                            }
                            if (i == 6 && (j >= 2 && j <= 5)) {    //上、左斜下、下、左斜上、左
                                put(i,j,1,2);//左上
                                put(i,j,6,2);//下
                                put(i,j,8,2);//左
                                put(i,j,7,2);//左下
                                put(i,j,2,2);//上
                            }
                            if ((i == 6 && j == 6)) {    //左、斜左上、上
                                put(i,j,2,2);//上
                                put(i,j,1,2);//左上
                                put(i,j,8,2);//左
                            }
                            if (j == 6 && (i >= 2 && i <= 5)) {    //上、左斜上、右、左斜上、左
                                put(i,j,1,2);//左上
                                put(i,j,4,2);//右
                                put(i,j,8,2);//左
                                put(i,j,3,2);//右上
                                put(i,j,2,2);//上
                            }
                        }
                        if ((i==0&&(j>=0||j<=7))||(i==7&&(j>=0||j<=7))||(j==0&&(i>=0||i<=7))||(j==7&&(i>=0||i<=7))){//外枠の場合
                            if ((i == 0 && j == 1) || (i == 1 && j == 0) || (i == 0 && j == 0)){//右、下、斜右下
                                put(i,j,4,2);//右
                                put(i,j,5,2);//右下
                                put(i,j,6,2);//下
                            }
                            if ((i == 7 && j == 1) || (i == 6 && j == 0) || (i == 7 && j == 0)){//左、左斜下、下
                                put(i,j,6,2);//下
                                put(i,j,7,2);//左下
                                put(i,j,8,2);//左
                            }
                            if ((i == 7 && j == 6) || (i == 6 && j == 7) || (i == 7 && j == 7)){//上、斜左上、左
                                put(i,j,1,2);//左上
                                put(i,j,2,2);//上
                                put(i,j,8,2);//左
                            }
                            if ((i == 0 && j == 6) || (i == 1 && j == 7) || (i == 0 && j == 7)){//上、右斜上、右
                                put(i,j,2,2);//上
                                put(i,j,3,2);//右上
                                put(i,j,4,2);//右
                            }
                            if (j == 0 && (i >=2 && i <=5)){//右、左、下、右下、左下
                                put(i,j,5,2);//右下
                                put(i,j,4,2);//右
                                put(i,j,8,2);//左
                                put(i,j,6,2);//下
                                put(i,j,7,2);//左下
                            }
                            if (i == 7 && (j >=2 && j <=5)){//上、下、左、左上、左下、
                                put(i,j,1,2);//左上
                                put(i,j,2,2);//上
                                put(i,j,6,2);//下
                                put(i,j,7,2);//左下
                                put(i,j,8,2);//左
                            }
                            if (j == 7 && (i >=2 && i <=5)){//上、右、左、右上、左上
                                put(i,j,1,2);//左上
                                put(i,j,3,2);//右上
                                put(i,j,4,2);//右
                                put(i,j,2,2);//上
                                put(i,j,8,2);//左

                            }
                            if (i == 0 && (j >=2 && j <=5)){//上、右、右上、右下、下
                                put(i,j,5,2);//右下
                                put(i,j,3,2);//右上
                                put(i,j,4,2);//右
                                put(i,j,2,2);//上
                                put(i,j,6,2);//下
                            }
                        }
                    }
                }
            }
        }
    }

    //画像はめ込みメソッド
    public void buttonMethod0(View Button) {  //画像をはめ込む
        ImageButton aImageButton = (ImageButton) Button;
        int button = Button.getId();
        String btn = ""+button;
        int x = Integer.parseInt(btn.substring(btn.length()-4));
        x = x - 949;
        int i = x / 8;
        int j = x % 8;
        if (button_flag[i][j] == 3){
                aImageButton.setBackgroundResource(R.drawable.kuro);
                button_flag[i][j] = 1;
                reverce(i,j,1);
        }
        if (button_flag[i][j] == 4){
            aImageButton.setBackgroundResource(R.drawable.siro);
            button_flag[i][j] = 2;
            reverce(i,j,2);
        }
    }

    //置換えメソッド
    private void retrun(int i, int j, int v, int s) {
        int flag = 0;
        int y = i;
        int t = j;
        if (s == 1) {
            if (v == 1) {
                for (int x = 0; i != 0 && j != 00 && flag != 1; x++) {//左斜検索
                    i = i - 1;
                    j = j - 1;
                    if (button_flag[i][j] == 1) {//黒の場合(黒ゴマ検索に行く)
                        for (int k = 1; i != y && j != t; k++) {
                            i = i + 1;
                            j = j + 1;
                            rever(i, j, 1);
                            flag = 1;
                        }
                    }
                }
            } else if (v == 2) {
                for (int x = 0; j != 0 && flag != 1; x++) {//上検索
                    j = j - 1;
                    if (button_flag[i][j] == 1) {//黒の場合(黒ゴマ検索に行く)
                        for (int k = 1; j != t; k++) {
                            j = j + 1;
                            rever(i, j, 1);
                            flag = 1;
                        }
                    }
                }
            } else if (v == 3) {
                for (int x = 0; i != 7 && j != 0 && flag != 1; x++) {//右斜上検索
                    i = i + 1;
                    j = j - 1;
                    if (button_flag[i][j] == 1) {//黒の場合(黒ゴマ検索に行く)
                        for (int k = 1; i != y && j != t; k++) {
                            i = i - 1;
                            j = j + 1;
                            rever(i, j, 1);
                            flag = 1;
                        }
                    }
                }
            } else if (v == 4) {
                for (int x = 0; i != 7 && flag != 1; x++) {//右検索
                    i = i + 1;
                    if (button_flag[i][j] == 1) {//黒の場合(黒ゴマ検索に行く)
                        for (int k = 1; i != y; k++) {
                            i = i - 1;
                            rever(i, j, 1);
                            flag = 1;
                        }
                    }
                }
            } else if (v == 5) {
                for (int x = 0; i != 7 && j != 7 && flag != 1; x++) {//右下検索
                    i = i + 1;
                    j = j + 1;
                    if (button_flag[i][i] == 1) {
                        for (int k = 1; i != y && j != t; k++) {
                            i = i - 1;
                            j = j - 1;
                            rever(i, j, 1);
                            flag = 1;
                        }
                    }
                }
            } else if (v == 6) {
                for (int x = 0; j != 7 && flag != 1; x++) {//下検索
                    j = j + 1;
                    if (button_flag[i][j] == 1) {//黒の場合(黒ゴマ検索に行く)
                        for (int k = 1; j != t; k++) {
                            j = j - 1;
                            rever(i, j, 1);
                            flag = 1;
                        }
                    }
                }
            } else if (v == 7) {
                for (int x = 0; i != 0 && j != 7 && flag != 1; x++) {//左下検索
                    i = i - 1;
                    j = j + 1;
                    if (button_flag[i][j] == 1) {//黒の場合(黒ゴマ検索に行く)
                        for (int k = 1; i != y && j != t; k++) {
                            i = i + 1;
                            j = j - 1;
                            rever(i, j, 1);
                            flag = 1;
                        }
                    }
                }
            } else if (v == 8) {
                for (int x = 0; i != 0 && flag != 1; x++) {//左検索
                    i = i - 1;
                    if (button_flag[i][j] == 1) {
                        for (int k = 1; i != y; k++) {
                            i = i + 1;
                            rever(i, j, 1);
                            flag = 1;
                        }
                    }
                }
            }
        } else {
            if (v == 1) {
                for (int x = 0; i != 0 && j != 00 && flag != 1; x++) {//左斜検索
                    i = i - 1;
                    j = j - 1;
                    if (button_flag[i][j] == 2) {//黒の場合(黒ゴマ検索に行く)
                        for (int k=1; i!=y&&j!=t; k++) {
                            i=i+1;
                            j=j+1;
                            rever(i,j,2);
                            flag=1;
                        }
                    }
                }
            } else if (v == 2) {
                for (int x = 0; j != 0 && flag != 1; x++) {//上検索
                    j = j - 1;
                    if (button_flag[i][j] == 2) {//黒の場合(黒ゴマ検索に行く)
                        for (int k=1; j!=t; k++) {
                            j=j+1;
                            rever(i,j,2);
                            flag=1;
                        }
                    }
                }
            } else if (v == 3) {
                for (int x=0; i!=7 && j!=0 && flag!=1; x++) {//右斜上検索
                    i = i + 1;
                    j = j - 1;
                    if (button_flag[i][j] == 2) {//黒の場合(黒ゴマ検索に行く)
                        for (int k=1; i!=y&&j!=t; k++) {
                            i=i-1;
                            j=j+1;
                            rever(i,j,2);
                            flag=1;
                        }
                    }
                }
            } else if (v == 4) {
                for (int x = 0; i != 7 && flag != 1; x++) {//右検索
                    i = i + 1;
                    if (button_flag[i][j] == 2) {//黒の場合(黒ゴマ検索に行く)
                        for (int k=1; i!=y; k++) {
                            i=i-1;
                            rever(i,j,2);
                            flag=1;
                        }
                    }
                }
            } else if (v == 5) {
                for (int x = 0; i != 7 && j != 7 && flag != 1; x++) {//右下検索
                    i = i + 1;
                    j = j + 1;
                    if (button_flag[i][i] == 2) {
                        for (int k=1; i!=y&&j!=t; k++) {
                            i=i-1;
                            j=j-1;
                            rever(i,j,2);
                            flag=1;
                        }
                    }
                }
            } else if (v == 6) {
                for (int x = 0; j != 7 && flag != 1; x++) {//下検索
                    j = j + 1;
                    if (button_flag[i][j] == 2) {//黒の場合(黒ゴマ検索に行く)
                        for (int k=1; j!=t; k++) {
                            j=j-1;
                            rever(i,j,2);
                            flag=1;
                        }
                    }
                }
            } else if (v == 7) {
                for (int x = 0; i != 0 && j != 7 && flag != 1; x++) {//左下検索
                    i = i - 1;
                    j = j + 1;
                    if (button_flag[i][j] == 2) {//黒の場合(黒ゴマ検索に行く)
                        for (int k=1; i!=y&&j!=t; k++) {
                            i=i+1;
                            j=j-1;
                            rever(i,j,2);
                            flag=1;
                        }
                    }
                }
            } else if (v == 8) {
                for (int x = 0; i != 0 && flag != 1; x++) {//左検索
                    i = i - 1;
                    if (button_flag[i][j] == 2) {
                        for (int k = 1; i != y; k++) {
                            i = i + 1;
                            rever(i, j, 2);
                            flag = 1;
                        }
                    }
                }
            }
        }
    }

    private void reverce(int i, int j, int senkou){
        int y=i;
        int t=j;
        if (senkou==1){
            if ((i==0&&(j>=0||j<=7))||(i==7&&(j>=0||j<=7))||(j==0&&(i>=0||i<=7))||(j==7&&(i>=0||i<=7))){
                if ((i == 0 && j == 1) || (i == 1 && j == 0) || (i == 0 && j == 0)){//右、下、斜右下
                    retrun(y,t,4,1);//右
                    retrun(y,t,6,1);//下
                    retrun(y,t,5,1);//右下
                }
                if ((i == 7 && j == 1) || (i == 6 && j == 0) || (i == 7 && j == 0)){//左、左斜下、下
                    retrun(y,t,8,1);//左
                    retrun(y,t,6,1);//下
                    retrun(y,t,7,1);//左下
                }
                if ((i == 7 && j == 6) || (i == 6 && j == 7) || (i == 7 && j == 7)){//上、斜左上、左
                    retrun(y,t,1,1);//左上
                    retrun(y,t,8,1);//左
                    retrun(y,t,2,1);//上
                }
                if ((i == 0 && j == 6) || (i == 1 && j == 7) || (i == 0 && j == 7)){//上、右斜上、右
                    retrun(y,t,2,1);//上
                    retrun(y,t,3,1);//右上
                    retrun(y,t,4,1);//右
                }
                if (j == 0 && (i >=2 && i <=5)){//右、左、下、右下、左下
                    retrun(y,t,5,1);//右下
                    retrun(y,t,4,1);//右
                    retrun(y,t,8,1);//左
                    retrun(y,t,6,1);//下
                    retrun(y,t,7,1);//左下
                }
                if (i == 7 && (j >=2 && j <=5)){//上、下、左、左上、左下、
                    retrun(y,t,1,1);//左上
                    retrun(y,t,2,1);//上
                    retrun(y,t,6,1);//下
                    retrun(y,t,7,1);//左下
                    retrun(y,t,8,1);//左
                }
                if (j == 7 && (i >=2 && i <=5)){//上、右、左、右上、左上
                    retrun(y,t,1,1);//左上
                    retrun(y,t,3,1);//右上
                    retrun(y,t,4,1);//右
                    retrun(y,t,2,1);//上
                    retrun(y,t,8,1);//左
                }
                if (i == 0 && (j >=2 && j <=5)){//上、右、右上、右下、下
                    retrun(y,t,5,1);//右下
                    retrun(y,t,3,1);//右上
                    retrun(y,t,4,1);//右
                    retrun(y,t,2,1);//上
                    retrun(y,t,6,1);//下
                }
            }else{
                if (button_flag[y - 1][t - 1] == 2) {
                    retrun(y,t,1,1);
                }
                if (button_flag[y][t - 1] == 2) {
                    retrun(y,t,2,1);
                }
                if (button_flag[y + 1][t - 1] == 2) {
                    retrun(y,t,3,1);
                }
                if (button_flag[y + 1][t] == 2) {
                    retrun(y,t,4,1);
                }
                if (button_flag[y + 1][t + 1] == 2) {
                    retrun(y,t,5,1);
                }
                if (button_flag[y][t + 1] == 2) {
                    retrun(y,t,6,1);
                }
                if (button_flag[y - 1][t + 1] == 2) {
                    retrun(y,t,7,1);
                }
                if (button_flag[y - 1][t] == 2) {
                    retrun(y,t,8,1);
                }
            }
            ex_put(2);
        }else{
            if ((i==0&&(j>=0||j<=7))||(i==7&&(j>=0||j<=7))||(j==0&&(i>=0||i<=7))||(j==7&&(i>=0||i<=7))){
                if ((i == 0 && j == 1) || (i == 1 && j == 0) || (i == 0 && j == 0)){//右、下、斜右下
                    retrun(y,t,4,2);//右
                    retrun(y,t,6,2);//下
                    retrun(y,t,5,2);//右下
                }
                if ((i == 7 && j == 1) || (i == 6 && j == 0) || (i == 7 && j == 0)){//左、左斜下、下
                    retrun(y,t,8,2);//左
                    retrun(y,t,6,2);//下
                    retrun(y,t,7,2);//左下
                }
                if ((i == 7 && j == 6) || (i == 6 && j == 7) || (i == 7 && j == 7)){//上、斜左上、左
                    retrun(y,t,1,2);//左上
                    retrun(y,t,8,2);//左
                    retrun(y,t,2,2);//上
                }
                if ((i == 0 && j == 6) || (i == 1 && j == 7) || (i == 0 && j == 7)){//上、右斜上、右
                    retrun(y,t,2,2);//上
                    retrun(y,t,3,2);//右上
                    retrun(y,t,4,2);//右
                }
                if (j == 0 && (i >=2 && i <=5)){//右、左、下、右下、左下
                    retrun(y,t,5,2);//右下
                    retrun(y,t,4,2);//右
                    retrun(y,t,8,2);//左
                    retrun(y,t,6,2);//下
                    retrun(y,t,7,2);//左下
                }
                if (i == 7 && (j >=2 && j <=5)){//上、下、左、左上、左下、
                    retrun(y,t,1,2);//左上
                    retrun(y,t,2,2);//上
                    retrun(y,t,6,2);//下
                    retrun(y,t,7,2);//左下
                    retrun(y,t,8,2);//左
                }
                if (j == 7 && (i >=2 && i <=5)){//上、右、左、右上、左上
                    retrun(y,t,1,2);//左上
                    retrun(y,t,3,2);//右上
                    retrun(y,t,4,2);//右
                    retrun(y,t,2,2);//上
                    retrun(y,t,8,2);//左
                }
                if (i == 0 && (j >=2 && j <=5)){//上、右、右上、右下、下
                    retrun(y,t,5,2);//右下
                    retrun(y,t,3,2);//右上
                    retrun(y,t,4,2);//右
                    retrun(y,t,2,2);//上
                    retrun(y,t,6,2);//下
                }
                }else{
                    if (button_flag[y-1][t-1] == 1) {
                        retrun(y,t,1,2);
                    }
                    if (button_flag[y][t-1] == 1) {
                        retrun(y,t,2,2);
                    }
                    if (button_flag[y+1][t-1] == 1) {
                        retrun(y,t,3,2);
                    }
                    if (button_flag[y+1][t] == 1) {
                        retrun(y,t,4,2);
                    }
                    if (button_flag[y+1][t+1] == 1) {
                        retrun(y,t,5,2);
                    }
                    if (button_flag[y][t+1] == 1) {
                        retrun(y,t,6,2);
                    }
                    if (button_flag[y-1][t+1] == 1) {
                        retrun(y,t,7,2);
                    }
                    if (button_flag[y-1][t] == 1) {
                        retrun(y,t,8,2);
                    }
                }
                ex_put(1);
            }
        }
    }