/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmatcher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Complex;
import model.FFT;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.tritonus.sampled.convert.PCM2PCMConversionProvider;

/**
 *
 * @author Brian Marwood && Emma Hughes
 */
public class MusicMatchGUI extends javax.swing.JFrame {

    //global variables
    boolean running = false;
    boolean isMic;
    File soundFile;
    String dirName = "C:\\Users\\" + System.getProperty("user.name") + "\\Music";
    byte[] audioBytes;
    OutputStream out;
    JFreeChart chart;
    double highscores[][];
    double recordPoints[][];
    Clip clip;

    /**
     * Creates new form MusicMatchGUI
     */
    public MusicMatchGUI() {
        initComponents();
        myComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    //----------------------------------------------------------------Swing Code---------------------------------------
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        importBtn = new javax.swing.JButton();
        listenBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        displayFileName = new javax.swing.JLabel();
        playSong = new javax.swing.JButton();
        stopBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        loadIcon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        songList = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        listChooseBtn = new javax.swing.JButton();
        timeDomain = new javax.swing.JPanel();
        specPanel = new javax.swing.JPanel();
        convertToTimeDomain = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        spectrumBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        clrSpecBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(815, 491));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        importBtn.setForeground(new java.awt.Color(0, 0, 153));
        importBtn.setText("Import File");
        importBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importBtnActionPerformed(evt);
            }
        });

        listenBtn.setForeground(new java.awt.Color(0, 0, 153));
        listenBtn.setText("Listen to Microphone");
        listenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listenBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Or");

        displayFileName.setText("---------Selected WAV File -------");

        playSong.setForeground(new java.awt.Color(0, 102, 0));
        playSong.setText("Play Song");
        playSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playSongActionPerformed(evt);
            }
        });

        stopBtn.setForeground(new java.awt.Color(153, 0, 51));
        stopBtn.setText("Stop Song");
        stopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopBtnActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setMaximumSize(new java.awt.Dimension(50, 50));
        jPanel6.setMinimumSize(new java.awt.Dimension(50, 50));
        jPanel6.setPreferredSize(new java.awt.Dimension(50, 50));

        loadIcon.setBackground(new java.awt.Color(255, 255, 255));
        loadIcon.setForeground(new java.awt.Color(255, 255, 255));
        loadIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicmatcher/gifCircle.gif"))); // NOI18N
        loadIcon.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(loadIcon))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(loadIcon))
        );

        songList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(songList);

        jLabel4.setText("List of Database songs");

        listChooseBtn.setText("Choose");
        listChooseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listChooseBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(importBtn)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)
                        .addComponent(listenBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(playSong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stopBtn))
                    .addComponent(displayFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(listChooseBtn)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(importBtn)
                                .addComponent(jLabel1)
                                .addComponent(listenBtn))
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(displayFileName)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stopBtn)
                    .addComponent(playSong)
                    .addComponent(listChooseBtn))
                .addGap(12, 12, 12))
        );

        timeDomain.setBackground(new java.awt.Color(255, 255, 255));
        timeDomain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        timeDomain.setMaximumSize(new java.awt.Dimension(354, 216));
        timeDomain.setMinimumSize(new java.awt.Dimension(216, 216));

        javax.swing.GroupLayout timeDomainLayout = new javax.swing.GroupLayout(timeDomain);
        timeDomain.setLayout(timeDomainLayout);
        timeDomainLayout.setHorizontalGroup(
            timeDomainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        timeDomainLayout.setVerticalGroup(
            timeDomainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 214, Short.MAX_VALUE)
        );

        specPanel.setBackground(new java.awt.Color(102, 102, 102));
        specPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        specPanel.setMaximumSize(new java.awt.Dimension(354, 216));
        specPanel.setMinimumSize(new java.awt.Dimension(354, 216));
        specPanel.setPreferredSize(new java.awt.Dimension(354, 216));

        javax.swing.GroupLayout specPanelLayout = new javax.swing.GroupLayout(specPanel);
        specPanel.setLayout(specPanelLayout);
        specPanelLayout.setHorizontalGroup(
            specPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
        );
        specPanelLayout.setVerticalGroup(
            specPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 214, Short.MAX_VALUE)
        );

        convertToTimeDomain.setText("Convert");
        convertToTimeDomain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertToTimeDomainActionPerformed(evt);
            }
        });

        jLabel5.setText("Full Spectrum Analyzer");

        spectrumBtn.setText("Get Spectrum");
        spectrumBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spectrumBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Time Domain Graph");

        clrSpecBtn.setText("Clear");
        clrSpecBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clrSpecBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(timeDomain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(convertToTimeDomain)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(153, 153, 153)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(specPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(spectrumBtn)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clrSpecBtn)))
                        .addGap(9, 9, 9)))
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(spectrumBtn)
                            .addComponent(clrSpecBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(specPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(convertToTimeDomain))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timeDomain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //----------------------------------------------------------------Swing Code----------------------------------------
    //onClickListeners
    private void importBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importBtnActionPerformed
        isMic = false;
        //checks if existing clip is existing and should be stopped
        if (clip != null) {
            clip.stop();
        }
        JFileChooser file = new javax.swing.JFileChooser();
        file.setCurrentDirectory(new File(dirName));
        //filter the files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Audio", "wav");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        //if the user click on save in Jfilechooser
        if (result == JFileChooser.APPROVE_OPTION) {
            soundFile = file.getSelectedFile();
            displayFileName.setText(soundFile.getName());
            try {
                parseAudio(isMic);
            } catch (UnsupportedAudioFileException | IOException ex) {
                Logger.getLogger(MusicMatchGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No File Select");
        }
    }//GEN-LAST:event_importBtnActionPerformed

    private void playSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playSongActionPerformed
        AudioInputStream sound = null;
        //code for if was mic input
        try {
            sound = AudioSystem.getAudioInputStream(soundFile);
        } catch (UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(MusicMatchGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //gets info for clip and plays for user
        DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
        try {
            clip = (Clip) AudioSystem.getLine(info);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(MusicMatchGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            clip.open(sound);
        } catch (LineUnavailableException | IOException ex) {
            Logger.getLogger(MusicMatchGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        clip.start();
    }//GEN-LAST:event_playSongActionPerformed

    private void convertToTimeDomainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertToTimeDomainActionPerformed
        createChart();
    }//GEN-LAST:event_convertToTimeDomainActionPerformed

    //starts microphone as input
    private void listenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listenBtnActionPerformed
        if (clip != null) {
            clip.stop();
        }
        try {
            //global isMic to true
            isMic = true;
            parseAudio(isMic);
        } catch (UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(MusicMatchGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_listenBtnActionPerformed

    private void spectrumBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spectrumBtnActionPerformed
        //passes in fastFouier which returns the Complex numbers that are needed. Generated from the global audioBytes
        paintFullSpec(fastFourier());
    }//GEN-LAST:event_spectrumBtnActionPerformed

    private void stopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopBtnActionPerformed
        clip.stop();
    }//GEN-LAST:event_stopBtnActionPerformed

    private void listChooseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listChooseBtnActionPerformed
        //is -1 one then its not selected on any item
        if (songList.getSelectedIndex() != -1) {
            isMic = false;
            System.out.println(songList.getSelectedValue());

            if (clip != null) {
                clip.stop();
            }
            //set new selected file as the one chosed from the list and parse its audio
            File selectedFile = new File(dirName + "\\" + songList.getSelectedValue());
            soundFile = selectedFile;
            displayFileName.setText(soundFile.getName());
            try {
                parseAudio(isMic);
            } catch (UnsupportedAudioFileException | IOException ex) {
                Logger.getLogger(MusicMatchGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_listChooseBtnActionPerformed

    private void clrSpecBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clrSpecBtnActionPerformed
        specPanel.repaint();
        
        //clear for Time Domain Graph
        boolean showLegend = false;
        boolean createURL = false;
        boolean createTooltip = false;
        XYDataset dataset = null;
        String chartTitle = "Time Domain Graph";
        String xAxisLabel = "Time";
        String yAxisLabel = "Sound";
         chart = ChartFactory.createXYLineChart(chartTitle, xAxisLabel, yAxisLabel, dataset,
                PlotOrientation.VERTICAL, showLegend, createURL, createTooltip);

        timeDomain.setLayout(new java.awt.BorderLayout());

        ChartPanel CP = new ChartPanel(chart);
        timeDomain.add(CP, BorderLayout.CENTER);
        timeDomain.validate();
        timeDomain.setPreferredSize(new Dimension(354, 216));
    }//GEN-LAST:event_clrSpecBtnActionPerformed

    //helper functions
    //gets desired audioFormat specs
    private AudioFormat getFormat() {
        float sampleRate = 44100;
        int sampleSizeInBits = 8;
        int channels = 1; // mono
        boolean signed = true;
        boolean bigEndian = true;
        return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed,
                bigEndian);
    }

    //creates the time domain chart
    private void createChart() {
        boolean showLegend = false;
        boolean createURL = false;
        boolean createTooltip = false;

        String chartTitle = "Time Domain Graph";
        String xAxisLabel = "Time";
        String yAxisLabel = "Sound";
        XYDataset dataset = createDataSet();

        chart = ChartFactory.createXYLineChart(chartTitle, xAxisLabel, yAxisLabel, dataset,
                PlotOrientation.VERTICAL, showLegend, createURL, createTooltip);

        timeDomain.setLayout(new java.awt.BorderLayout());

        ChartPanel CP = new ChartPanel(chart);
        timeDomain.add(CP, BorderLayout.CENTER);
        timeDomain.validate();
        timeDomain.setPreferredSize(new Dimension(354, 216));
    }

    //adds datasets for time domain chart
    private XYDataset createDataSet() {

        System.out.println("InCreatedata");

        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("Object 1");
        if (audioBytes != null) {
            for (int i = 0; i < audioBytes.length; i++) {
                series.add(i, audioBytes[i]);
            }
            dataset.addSeries(series);
        }

        return dataset;
    }

    private void parseAudio(boolean isMic) throws UnsupportedAudioFileException, IOException, UnsupportedAudioFileException {
        AudioInputStream din = null;
        PCM2PCMConversionProvider conversionProvider = new PCM2PCMConversionProvider();
        //for files
        AudioInputStream fileInputStream = null;
        //format and line is for mic
        AudioFormat formatTmp = null;
        TargetDataLine lineTmp = null;
        try {
            //for Microphone
            if (isMic) {
                formatTmp = getFormat();
                //get infor
                DataLine.Info infoDataLine = new DataLine.Info(TargetDataLine.class,
                        formatTmp);
                //line from system (microphpone)
                lineTmp = (TargetDataLine) AudioSystem.getLine(infoDataLine);
            } else { //for files
                AudioInputStream in = AudioSystem.getAudioInputStream(soundFile);
                //reformat the data from the file into a convertable format to be read as a Stream
                AudioFormat baseFormat = in.getFormat();

                AudioFormat decodedFormat = new AudioFormat(
                        AudioFormat.Encoding.PCM_SIGNED,
                        baseFormat.getSampleRate(), 16, baseFormat.getChannels(),
                        baseFormat.getChannels() * 2, baseFormat.getSampleRate(),
                        false);

                din = AudioSystem.getAudioInputStream(decodedFormat, in);

                if (conversionProvider.isConversionSupported(getFormat(),
                        decodedFormat)) {
                } else {
                    System.out.println("Conversion is not supported");
                }

                fileInputStream = conversionProvider.getAudioInputStream(getFormat(), din);
            }

            final AudioFormat format = formatTmp;
            final TargetDataLine line = lineTmp;
            final AudioInputStream fileInputStreamFinal = fileInputStream;

            //if microphone then open the correct microphone line and start it
            if (isMic) {
                line.open(format);
                line.start();
            }

            //start of listening/getting data thread
            Thread nowListen;
            nowListen = new Thread(() -> {
                //show to user that thread is currently running
                loadIcon.setVisible(true);
                System.out.println("into Listening Thread");
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                running = true;
                byte[] buffer = new byte[(int) 1024];
                int timer = 0;
                int lengthOfTime = 0;
                if (isMic) {
                    lengthOfTime = 400;
                } else {
                    lengthOfTime = 700;
                }
                try {
                    while (running) {
                        timer++;
                        if (timer > lengthOfTime) {
                            break;
                        }
                        int count;
                        //could input somesort of break here to stop thread running
                        if (isMic) {
                            count = line.read(buffer, 0, buffer.length);
                        } else {
                            count = fileInputStreamFinal.read(buffer, 0, buffer.length);
                        }
                        if (count > 0) {
                            out.write(buffer, 0, count);
                        }
                    }
                    audioBytes = out.toByteArray();
                    System.out.println("into mic");
                    //code for outputting mic to .wav file
                    if (isMic) {
                        File file = new File(dirName + "\\myMicrophone.wav");
                        ByteArrayInputStream bais = new ByteArrayInputStream(audioBytes);
                        
                        AudioInputStream backToAis = new AudioInputStream(bais, format, audioBytes.length);
                        try {
                            AudioSystem.write(backToAis, AudioFileFormat.Type.WAVE, file);
                            soundFile = file;
                            displayFileName.setText(soundFile.getName());
                        } catch (IOException e) {
                        }

                    }
                    //byteArray output to a text file
                    try {
                        FileWriter fstream = new FileWriter("byte array.txt");
                        try (final BufferedWriter outFile = new BufferedWriter(fstream)) {
                            for (int i = 0; i < audioBytes.length; i++) {
                                outFile.write("" + audioBytes[i] + " ");
                            }
                        }
                    } catch (IOException e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                    //if microphone is running then stop and close the line
                    if (isMic) {
                        out.close();
                        line.close();
                    }
                } catch (IOException e) {
                    System.err.println("I/O problems: " + e.getMessage());
                    System.exit(-1);
                }
                //while the thread is running then display the loading icon
                loadIcon.setVisible(false);
            });
            //start the thread
            nowListen.start();

            System.out.println(
                    "Ended Sound Test");
        } catch (LineUnavailableException ex) {
            Logger.getLogger(MusicMatchGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //calls the fast fourier transform on the byte array to return a complex version of the frequencies
    public Complex[][] fastFourier() {
        byte[] fourierBytes = audioBytes;
        int maxAmount = fourierBytes.length / 4096;
        //make complex numbers for freq. domain
        Complex[][] result = new Complex[maxAmount][];
        for (int times = 0; times < maxAmount; times++) {
            Complex[] complex = new Complex[4096];
            for (int i = 0; i < 4096; i++) {
                //Put the time domain data into a complex number with imaginary part as 0: 
                complex[i] = new Complex(fourierBytes[(times * 4096) + i], 0);
            }
            //Perform FFT analysis on the chunk: 
            result[times] = FFT.fft(complex);
        }
        return result;
    }
    
    //paints the spectrum on the designated JPanel from a set of complex numbers
    public void paintFullSpec(Complex[][] currSong) {
        Graphics2D spectrum = (Graphics2D) specPanel.getGraphics();
        int blockSizeX = 2;
        int blockSizeY = 3;

        for (int i = 0; i < currSong.length; i++) {
            int freq = 1;
            for (int line = 1; line < 4096; line++) {

                double magnitude = Math.log(currSong[i][freq].abs() + 1);

                // The more blue in the color the more intensity for a given frequency point: 
                spectrum.setColor(new Color(0, (int) magnitude * 10, (int) magnitude * 20));
                spectrum.fillRect(i * blockSizeX, (4096 - line) * blockSizeY, blockSizeX, blockSizeY);

                if (false && Math.pow(Math.log10(line), 2) > 1) {
                    freq = ((int) Math.pow(Math.log10(line), 2)) + freq;
                } else {
                    freq++;
                }
            }
        }
    }

    //populates JList on startup
    public void populateList() {
        DefaultListModel model = new DefaultListModel();
        File dir = new File(dirName);
        File[] files;
        files = dir.listFiles((File dir1, String name1) -> name1.toLowerCase().endsWith(".wav"));
        for (File f : files) {
            model.addElement(f.getName());
        }
        songList.setModel(model);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MusicMatchGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MusicMatchGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MusicMatchGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MusicMatchGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MusicMatchGUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clrSpecBtn;
    private javax.swing.JButton convertToTimeDomain;
    private javax.swing.JLabel displayFileName;
    private javax.swing.JButton importBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listChooseBtn;
    private javax.swing.JButton listenBtn;
    private javax.swing.JLabel loadIcon;
    private javax.swing.JButton playSong;
    private javax.swing.JList<String> songList;
    private javax.swing.JPanel specPanel;
    private javax.swing.JButton spectrumBtn;
    private javax.swing.JButton stopBtn;
    private javax.swing.JPanel timeDomain;
    // End of variables declaration//GEN-END:variables

    private void myComponents() {
        loadIcon.setVisible(false);
        populateList();
    }
}
