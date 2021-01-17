package lesson07;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {
    private static final int WIN_WIDTH =  350;
    private static final int WIN_HEIGHT =  270;

    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_LENGTH = 3;
    private static final int MAX_FIELD_LENGTH = 10;

    private static final String FIELD_SIZE_TEXT_PREFIX = "Размер поля: ";
    private static final String WIN_LENGTH_TEXT_PREFIX = "Выиграшная длинна: ";

    private MainWindow mainWindow;
    private JRadioButton humanVsAi;
    private JRadioButton humanVsHuman;
    private JSlider sliderWinLen;
    private JSlider slideFieldSize;

    Settings(MainWindow mainWindow){
        this.mainWindow = mainWindow;
        setSize(WIN_WIDTH, WIN_HEIGHT);

        Rectangle gameWindowBounds = mainWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WIN_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WIN_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle("Настройки новой игры");

        setLayout(new GridLayout(10, 1));
        addGameModeSettings();
        addFieldSizeControl();

        JButton btnStartGame = new JButton("Начать новую игру");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartClick();
            }
        });
        add(btnStartGame);
    }

    private void addGameModeSettings(){
        add(new JLabel("Выберите режим игры"));
        humanVsAi = new JRadioButton("Human vs AI", true);
        humanVsHuman = new JRadioButton("Human vs Human");
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humanVsAi);
        gameMode.add(humanVsHuman);
        add(humanVsAi);
        add(humanVsHuman);
    }

    private void addFieldSizeControl(){
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_TEXT_PREFIX + MIN_FIELD_LENGTH);
        JLabel lbWinLength = new JLabel(WIN_LENGTH_TEXT_PREFIX + MIN_WIN_LENGTH);

        slideFieldSize = new JSlider(MIN_FIELD_LENGTH, MAX_FIELD_LENGTH, MIN_FIELD_LENGTH);
        slideFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slideFieldSize.getValue();
                lbFieldSize.setText(FIELD_SIZE_TEXT_PREFIX + currentValue);
                sliderWinLen.setMaximum(currentValue);
            }
        });

        sliderWinLen = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_LENGTH, MIN_FIELD_LENGTH);
        sliderWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_TEXT_PREFIX + sliderWinLen.getValue());
            }
        });

        add(new JLabel("выберите размер поля"));

        add(lbFieldSize);
        add(slideFieldSize);

        add(new JLabel("выберите выигрушную позицию"));
        add(lbWinLength);
        add(sliderWinLen);
    }

    private void btnStartClick(){
        int gameMode;
        if(humanVsAi.isSelected()){
            gameMode = GameMap.GAME_MODE_HVA;
        } else if(humanVsHuman.isSelected()){
            gameMode = GameMap.GAME_MODE_HVH;
        } else {
            throw new RuntimeException("Неизвешный режим игры");
        }

        int fieldSize = slideFieldSize.getValue();
        int winLen = sliderWinLen.getValue();

        mainWindow.startNewGame(gameMode, fieldSize, fieldSize, winLen);
        setVisible(false);
    }

}
