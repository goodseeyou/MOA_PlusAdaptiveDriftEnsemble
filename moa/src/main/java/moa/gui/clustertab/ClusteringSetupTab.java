/*
 *    ClusteringSetupTab.java
 *    Copyright (C) 2010 RWTH Aachen University, Germany
 *    @author Jansen (moa@cs.rwth-aachen.de)
 *
<<<<<<< HEAD
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program. If not, see <http://www.gnu.org/licenses/>.
=======
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *    
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
 *    
 */

package moa.gui.clustertab;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import moa.clusterers.AbstractClusterer;
import moa.evaluation.MeasureCollection;
import moa.gui.FileExtensionFilter;
import moa.gui.TextViewerPanel;
import moa.streams.clustering.ClusteringStream;

public class ClusteringSetupTab extends javax.swing.JPanel {
    private ClusteringTabPanel clusteringTab;
    private String lastfile;

    /** Creates new form ClusteringSetupTab */
    public ClusteringSetupTab() {
        initComponents();
        clusteringAlgoPanel0.renderAlgoPanel();
    }

    public AbstractClusterer getClusterer0(){
        return clusteringAlgoPanel0.getClusterer0();
    }

    public AbstractClusterer getClusterer1(){
        return clusteringAlgoPanel0.getClusterer1();
    }

    public ClusteringStream getStream0(){
        return clusteringAlgoPanel0.getStream();
    }

    public MeasureCollection[] getMeasures(){
        return clusteringEvalPanel1.getSelectedMeasures();
    }

    public TextViewerPanel getLogPanel(){
        return logPanel;
    }

    public void addButtonActionListener(ActionListener l){
        buttonWeka.addActionListener(l);
        buttonWeka.setActionCommand("weka export");
        buttonExport.addActionListener(l);
        buttonExport.setActionCommand("csv export");
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        clusteringAlgoPanel0 = new moa.gui.clustertab.ClusteringAlgoPanel();
        clusteringEvalPanel1 = new moa.gui.clustertab.ClusteringEvalPanel();
        buttonStart = new javax.swing.JButton();
        buttonStop = new javax.swing.JButton();
        buttonExport = new javax.swing.JButton();
        buttonWeka = new javax.swing.JButton();
        buttonImportSettings = new javax.swing.JButton();
        buttonExportSettings = new javax.swing.JButton();
        logPanel = new moa.gui.TextViewerPanel();

        setLayout(new java.awt.GridBagLayout());

        clusteringAlgoPanel0.setMinimumSize(new java.awt.Dimension(335, 150));
        clusteringAlgoPanel0.setPanelTitle("Cluster Algorithm Setup");
        clusteringAlgoPanel0.setPreferredSize(new java.awt.Dimension(335, 150));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(clusteringAlgoPanel0, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(clusteringEvalPanel1, gridBagConstraints);

        buttonStart.setText("Start");
        buttonStart.setPreferredSize(new java.awt.Dimension(80, 23));
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(buttonStart, gridBagConstraints);

        buttonStop.setText("Stop");
        buttonStop.setEnabled(false);
        buttonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStopActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(buttonStop, gridBagConstraints);

        buttonExport.setText("Export CSV");
        buttonExport.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(buttonExport, gridBagConstraints);

        buttonWeka.setText("Weka Explorer");
        buttonWeka.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(buttonWeka, gridBagConstraints);

        buttonImportSettings.setText("Import");
        buttonImportSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImportSettingsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(4, 75, 4, 4);
        add(buttonImportSettings, gridBagConstraints);

        buttonExportSettings.setText("Export");
        buttonExportSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExportSettingsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(buttonExportSettings, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(logPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonImportSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImportSettingsActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(true);
        fileChooser.addChoosableFileFilter(new FileExtensionFilter("txt"));
        if(lastfile!=null)
            fileChooser.setSelectedFile(new File(lastfile));
        if (fileChooser.showOpenDialog(this.buttonImportSettings) == JFileChooser.APPROVE_OPTION) {
            lastfile = fileChooser.getSelectedFile().getPath();
            loadOptionsFromFile(fileChooser.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_buttonImportSettingsActionPerformed

    private void buttonExportSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExportSettingsActionPerformed
        StringBuffer sb = new StringBuffer();
        sb.append(clusteringAlgoPanel0.getStreamValueAsCLIString()+"\n");
        sb.append(clusteringAlgoPanel0.getAlgorithm0ValueAsCLIString()+"\n");
        sb.append(clusteringAlgoPanel0.getAlgorithm1ValueAsCLIString()+"\n");
        
        System.out.println(sb);
        logPanel.addText(sb.toString());
        
    }//GEN-LAST:event_buttonExportSettingsActionPerformed

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
        toggle(true);
    }//GEN-LAST:event_buttonStartActionPerformed

    private void buttonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStopActionPerformed
        stop(true);
    }//GEN-LAST:event_buttonStopActionPerformed


    private void loadOptionsFromFile(String filepath){
        try {
            BufferedReader in = new BufferedReader(new FileReader(filepath));

            String stream0 = in.readLine();
            clusteringAlgoPanel0.setStreamValueAsCLIString(stream0);

            String algo0 = in.readLine();
            clusteringAlgoPanel0.setAlgorithm0ValueAsCLIString(algo0);

            String algo1 = in.readLine();
            clusteringAlgoPanel0.setAlgorithm1ValueAsCLIString(algo1);


            System.out.println("Loading settings from "+filepath);
            logPanel.addText("Loading settings from "+filepath);

        } catch (Exception e) {
            System.out.println("Bad option file:"+e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExport;
    private javax.swing.JButton buttonExportSettings;
    private javax.swing.JButton buttonImportSettings;
    private javax.swing.JButton buttonStart;
    private javax.swing.JButton buttonStop;
    private javax.swing.JButton buttonWeka;
    private moa.gui.clustertab.ClusteringAlgoPanel clusteringAlgoPanel0;
    private moa.gui.clustertab.ClusteringEvalPanel clusteringEvalPanel1;
    private moa.gui.TextViewerPanel logPanel;
    // End of variables declaration//GEN-END:variables

    void setClusteringTab(ClusteringTabPanel clusteringTab) {
        this.clusteringTab = clusteringTab;
    }

    public void toggleRunMode(){
        toggle(false);
    }

    public void stopRun(){
        stop(false);
    }

    private void toggle(boolean internal) {
        setStateConfigButtons(false);
        if(buttonStart.getText().equals("Pause")){
            buttonStart.setText("Resume");
            buttonWeka.setEnabled(true);
            buttonExport.setEnabled(true);
        }
        else{
            buttonStart.setText("Pause");
            buttonWeka.setEnabled(false);
            buttonExport.setEnabled(false);
        }

        //push event forward to the cluster tab
        if(internal)
            clusteringTab.toggle();
    }


    private void stop(boolean internal) {
        buttonStart.setEnabled(true);
        buttonStart.setText("Start");
        buttonStop.setEnabled(false);
        buttonWeka.setEnabled(false);
        buttonExport.setEnabled(false);
        setStateConfigButtons(true);

        //push event forward to the cluster tab
        if(internal)
            clusteringTab.stop();
    }

    private void setStateConfigButtons(boolean state){
        buttonStop.setEnabled(!state);
        buttonExportSettings.setEnabled(state);
        buttonImportSettings.setEnabled(state);
    }


}
