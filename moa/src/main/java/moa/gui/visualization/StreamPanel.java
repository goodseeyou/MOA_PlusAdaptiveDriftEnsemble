<<<<<<< HEAD
/*
 *    StreamPanel.java
 *    Copyright (C) 2010 RWTH Aachen University, Germany
 *    @author Jansen (moa@cs.rwth-aachen.de)
 *
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
/**
 * StreamPanel.java
 * 
 * @author Timm Jansen (moa@cs.rwth-aachen.de)
 * @editor Yunsu Kim
 * 
 * Last edited: 2013/06/02 
 *
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

package moa.gui.visualization;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import moa.cluster.Clustering;
import moa.cluster.SphereCluster;

public class StreamPanel extends JPanel implements ComponentListener{

    private ClusterPanel highlighted_cluster = null;
=======
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import moa.cluster.Cluster;
import moa.cluster.Clustering;
import moa.cluster.SphereCluster;
import moa.clusterers.macro.NonConvexCluster;

public class StreamPanel extends JPanel implements ComponentListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ClusterPanel highlighted_cluster = null;
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
    private double zoom_factor = 0.2;
    private int zoom = 1;
    private int width_org;
    private int height_org;
    private int activeXDim = 0;
    private int activeYDim = 1;

    
    private JPanel layerPoints;
    private JPanel layerMicro;
    private JPanel layerMacro;
    private JPanel layerGroundTruth;

    //Buffered Image stuff
    private BufferedImage pointCanvas;
    private pointCanvasPanel layerPointCanvas;
    private boolean pointsVisible = true;
    private boolean ANTIALIAS = false;


    class pointCanvasPanel extends JPanel{
<<<<<<< HEAD
        BufferedImage image = null;
=======
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		BufferedImage image = null;
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
        public void setImage(BufferedImage image){
            setSize(image.getWidth(), image.getWidth());
            this.image = image;
        }
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            if(image!=null)
                g2.drawImage(image, null, 0, 0);
        }
    }


    /** Creates new form StreamPanel */
    public StreamPanel() {
        initComponents();

        layerPoints = getNewLayer();
        layerPoints.setOpaque(true);
        layerPoints.setBackground(Color.white);
        
        layerMicro = getNewLayer();
        layerMacro = getNewLayer();
        layerGroundTruth = getNewLayer();

        add(layerMacro);
        add(layerMicro);
        add(layerGroundTruth);
        add(layerPoints);

        layerPointCanvas = new pointCanvasPanel();
        add(layerPointCanvas);
        
        addComponentListener(this);
        
    }


    private JPanel getNewLayer(){
        JPanel layer = new JPanel();
        layer.setOpaque(false);
        layer.setLayout(null);
        return layer;
    }


<<<<<<< HEAD
    public void drawMicroClustering(Clustering clustering, Color color){
        drawClustering(layerMicro, clustering, color);
    }
    
    public void drawMacroClustering(Clustering clustering, Color color){
        drawClustering(layerMacro, clustering, color);
    }
    public void drawGTClustering(Clustering clustering, Color color){
        drawClustering(layerGroundTruth, clustering, color);
=======
    public void drawMicroClustering(Clustering clustering, List<DataPoint> points, Color color){
        drawClustering(layerMicro, clustering, points, color);
    }
    
    public void drawMacroClustering(Clustering clustering, List<DataPoint> points, Color color){
        drawClustering(layerMacro, clustering, points, color);
    }
    public void drawGTClustering(Clustering clustering, List<DataPoint> points, Color color){
        drawClustering(layerGroundTruth, clustering, points, color);
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
    }

    public void setMicroLayerVisibility(boolean visibility){
        layerMicro.setVisible(visibility);
    }
    public void setMacroLayerVisibility(boolean visibility){
        layerMacro.setVisible(visibility);
    }
    public void setGroundTruthLayerVisibility(boolean visibility){
        layerGroundTruth.setVisible(visibility);
    }
    public void setPointVisibility(boolean visibility){
        pointsVisible = visibility;
        layerPoints.setVisible(visibility);
        if(!visibility)
            layerPointCanvas.setVisible(false);
    }

    void drawPointPanels(ArrayList<DataPoint> points, int timestamp, double decay_rate, double decay_threshold) {
        for(int p = 0; p < points.size(); p++){
<<<<<<< HEAD
            PointPanel pointPanel = new PointPanel(points.get(p),decay_rate,decay_threshold);
=======
            PointPanel pointPanel = new PointPanel(points.get(p), this, decay_rate, decay_threshold);
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
            layerPoints.add(pointPanel);
            pointPanel.updateLocation();
        }
        layerPointCanvas.setVisible(false);
        layerPoints.setVisible(pointsVisible);
    }

    public void drawPoint(DataPoint point){
        layerPointCanvas.setVisible(pointsVisible);
        layerPoints.setVisible(false);
        if(!pointsVisible)
            return;

        Graphics2D imageGraphics = (Graphics2D) pointCanvas.createGraphics();

        if (ANTIALIAS) {
            imageGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }


        int size = Math.min(getWidth(), getHeight());
        int x = (int) Math.round(point.value(getActiveXDim()) * size);
        int y = (int) Math.round(point.value(getActiveYDim()) * size);

<<<<<<< HEAD
        Color c = PointPanel.getPointColorbyClass((int)point.classValue(), 10);
=======
        Color c = PointPanel.getPointColorbyClass(point, 10);
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
        imageGraphics.setColor(c);
        int psize = PointPanel.POINTSIZE;
        int poffset = 2;
        imageGraphics.drawOval(x - poffset, y - poffset, psize, psize);
        imageGraphics.fillOval(x - poffset, y - poffset, psize, psize);

        layerPointCanvas.repaint();
    }


<<<<<<< HEAD
    private void drawCanvansClustering(JPanel layer, Graphics2D imageGraphics){
=======
    private void drawClusteringsOnCanvas(JPanel layer, Graphics2D imageGraphics){
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
        for(Component comp :layer.getComponents()){
            if(comp instanceof ClusterPanel){
                ClusterPanel cp = (ClusterPanel)comp;
                cp.drawOnCanvas(imageGraphics);
            }
        }
    }


    public void applyDrawDecay(float factor){

        RescaleOp brightenOp = new RescaleOp(1f, 150f/factor, null);
        pointCanvas = brightenOp.filter(pointCanvas, null);

        layerPointCanvas.setImage(pointCanvas);
        layerPointCanvas.repaint();
    }

<<<<<<< HEAD
    private void drawClustering(JPanel layer, Clustering clustering, Color color){
        layer.removeAll();
        for (int c = 0; c < clustering.size(); c++) {
            SphereCluster cluster = (SphereCluster)clustering.get(c);

            ClusterPanel clusterpanel = new ClusterPanel(cluster, color, this);
            
            layer.add(clusterpanel);
            clusterpanel.updateLocation();
        }

        if(layer.isVisible() && pointsVisible){
            Graphics2D imageGraphics = (Graphics2D) pointCanvas.createGraphics();
            imageGraphics.setColor(color);
            drawCanvansClustering(layer, imageGraphics);
            layerPointCanvas.repaint();
        }

        layer.repaint();
=======
    private void drawClustering(JPanel layer, Clustering clustering, List<DataPoint> points, Color color){
        if (clustering.get(0) instanceof NonConvexCluster) {
        	drawNonConvexClustering(layer, clustering, points, color);
        } else {	
	    	layer.removeAll();
	        for (int c = 0; c < clustering.size(); c++) {
	            SphereCluster cluster = (SphereCluster)clustering.get(c);
	
	            ClusterPanel clusterpanel = new ClusterPanel(cluster, color, this);
	            
	            layer.add(clusterpanel);
	            clusterpanel.updateLocation();
	        }
	
	        if(layer.isVisible() && pointsVisible){
	            Graphics2D imageGraphics = (Graphics2D) pointCanvas.createGraphics();
	            imageGraphics.setColor(color);
	            drawClusteringsOnCanvas(layer, imageGraphics);
	            layerPointCanvas.repaint();
	        }
	
	        layer.repaint();
        }
    }
    
    private void drawNonConvexClustering(JPanel layer, Clustering clustering, List<DataPoint> points, Color color) {
    	layerMacro.removeAll();
    	
    	List<Cluster> foundClusters = clustering.getClustering();
    	double inclusionProbabilityThreshold = 0.5;
    	for (DataPoint p : points) {
    		for (int i = 0; i < foundClusters.size(); i++) {
    			Cluster fc = foundClusters.get(i);
    			if (fc.getInclusionProbability(p) >= inclusionProbabilityThreshold) {
    				PointPanel pointPanel = new PointPanel(p, this, color);
    			    layerMacro.add(pointPanel);
    			    pointPanel.updateLocation();
    			}
    		}
    	}

        if (layerMacro.isVisible() && pointsVisible) {	// Points & Macro together
            Graphics2D imageGraphics = (Graphics2D) pointCanvas.createGraphics();
            imageGraphics.setColor(color);
            drawClusteringsOnCanvas(layerMacro, imageGraphics);
            layerPointCanvas.repaint();
        }

        layerMacro.repaint();
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
    }

    public void screenshot(String filename, boolean svg, boolean png){
    	if(layerPoints.getComponentCount()==0 && layerMacro.getComponentCount()==0 && layerMicro.getComponentCount()==0)
    		return;
    	
        BufferedImage image = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
        if(png){
            synchronized(getTreeLock()){
                Graphics g = image.getGraphics();
                paintAll(g);
                try {
                    ImageIO.write(image, "png", new File(filename+".png"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if(svg){
            try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename+".svg")));
                int width = 500;
                out.write("<?xml version=\"1.0\"?>\n");
                out.write("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n");
                out.write("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\""+width+"\" height=\""+width+"\">\n");

                if(layerMicro.isVisible()){
                    for(Component comp :layerMicro.getComponents()){
                        if(comp instanceof ClusterPanel)
                            out.write(((ClusterPanel)comp).getSVGString(width));
                    }
                }

                if(layerMacro.isVisible()){
                    for(Component comp :layerMacro.getComponents()){
                        if(comp instanceof ClusterPanel)
                            out.write(((ClusterPanel)comp).getSVGString(width));
                    }
                }

                if(layerGroundTruth.isVisible()){
                    for(Component comp :layerGroundTruth.getComponents()){
                        if(comp instanceof ClusterPanel)
                            out.write(((ClusterPanel)comp).getSVGString(width));
                    }
                }

                if(layerPoints.isVisible()){
                    for(Component comp :layerPoints.getComponents()){
                        if(comp instanceof PointPanel){
                            PointPanel pp = (PointPanel) comp;
                            out.write(pp.getSVGString(width));
                        }
                    }
                }
                
                out.write("</svg>");
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(StreamPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ClusterPanel getHighlightedClusterPanel(){
        return highlighted_cluster;
    }

    public void setHighlightedClusterPanel(ClusterPanel clusterpanel){
        highlighted_cluster = clusterpanel;
        repaint();
    }

    public void setZoom(int x, int y, int zoom_delta, JScrollPane scrollPane){
        
        if(zoom ==1){
            width_org = getWidth();
            height_org = getHeight();
        }
        zoom+=zoom_delta;
        
        if(zoom<1) zoom = 1;
        else{
            int size = (int)(Math.min(width_org, height_org)*zoom_factor*zoom);

            setSize(new Dimension(size*zoom, size*zoom));
            setPreferredSize(new Dimension(size*zoom, size*zoom));

            scrollPane.getViewport().setViewPosition(new Point((int)(x*zoom_factor*zoom+x),(int)( y*zoom_factor*zoom+y)));
        }
    }

    public int getActiveXDim() {
        return activeXDim;
    }

    public void setActiveXDim(int activeXDim) {
        this.activeXDim = activeXDim;
    }

    public int getActiveYDim() {
        return activeYDim;
    }

    public void setActiveYDim(int activeYDim) {
        this.activeYDim = activeYDim;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if(highlighted_cluster!=null){
            highlighted_cluster.highlight(false);
            highlighted_cluster=null;
        }
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    
    
    public void componentHidden(ComponentEvent e) {
    }

    public void componentMoved(ComponentEvent e) {
    }

    public void componentResized(ComponentEvent e) {
        //System.out.println(e.getComponent().getClass().getName() + " --- Resized ");

        int size = Math.min(getWidth(), getHeight());
        layerMicro.setSize(new Dimension(size,size));
        layerMacro.setSize(new Dimension(size,size));
        layerGroundTruth.setSize(new Dimension(size,size));
        layerPoints.setSize(new Dimension(size,size));


        pointCanvas = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        layerPointCanvas.setSize(new Dimension(size,size));
        layerPointCanvas.setImage(pointCanvas);

        Graphics2D imageGraphics = (Graphics2D) pointCanvas.getGraphics();
        imageGraphics.setColor(Color.white);
        imageGraphics.fillRect(0, 0, getWidth(), getHeight());
        imageGraphics.dispose();

    }

    public void componentShown(ComponentEvent e) {
    }


}
