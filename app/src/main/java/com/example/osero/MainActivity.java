package com.example.osero;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageButton[][] rectButtons = new ImageButton[8][8];
    private boolean first = true;
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
        ex_put();
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
        first = true;
    }

    //put画像をいれるメソッド
    private void ex_put(){
        int y = 0;
        //先行かどうか判断
        if (first=true){
            //黒ゴマを探す
            for (int i=0; i<8; i++){
                for (int j=0; j<8; j++){
                    y=y+1;
                    if (button_flag[i][j]==1) {//黒ゴマがあった場合
                        int flag=0;
                        int yoko = i;
                        int tate = j;
                        if ((yoko>=2&&yoko<=5)&&(tate>=2&&tate<=5)) {//8方向検索
                            for (int x=0;yoko!=0&&tate!=0&&flag!=1; x++) {//左斜上検索
                                yoko =yoko-1;
                                tate=tate-1;
                                if (button_flag[yoko][tate] == 1) {//黒の場合(黒ゴマ検索に行く)
                                    flag = 1;
                                } else if (button_flag[yoko][tate] != 1 && button_flag[yoko][tate] != 2) {//何もない場合(1週目:黒ゴマ検索に行)(2週目以降:put画像配置)
                                    if (x == 0) {//1週目
                                        flag = 1;
                                    } else {//2週目
                                        rectButtons[yoko][tate].setBackgroundResource(R.drawable.put);
                                        button_flag[yoko][tate] = 3;//黒コマが置ける場所
                                        flag=1;
                                    }
                                }//白の場合何もしない
                            }
                        }
                    }
                }
            }
        }
    }
}