package br.unicamp.MC322.lab11.engine.graphical;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.unicamp.MC322.lab11.engine.GameEngine;
import br.unicamp.MC322.lab11.model.Direction;
import br.unicamp.MC322.lab11.model.LabyrinthMap;

public class GraphicalEngine extends GameEngine{

	private GraphicalRenderManager renderManager;
	private GraphicalKeyListener keyListener;
	
	public GraphicalEngine(LabyrinthMap labyrinthMap) {
		super(labyrinthMap);
		this.renderManager = new GraphicalRenderManager();
		this.keyListener = new GraphicalKeyListener();
	}

	private JPanel createPanel() {
		JPanel panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				renderManager.render(g, getLabyrinthMap());
			}
		};
		int width = getLabyrinthMap().getWidth() * GraphicalRenderManager.BLOCK_SIZE;
		int height = getLabyrinthMap().getHeight() * GraphicalRenderManager.BLOCK_SIZE;
		panel.setPreferredSize(new Dimension(width, height));
		return panel;
	}
	
	private JFrame createWindow(JPanel panel) {
		JFrame window = new JFrame();
		window.add(panel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.addKeyListener(keyListener);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return window;
	}
	
	
	//gameLoop para ENGINE COM IMAGENS
	@Override
	public void gameLoop() {
		try {
			ImageLoder.getInstance().loadAllImg();
			JPanel gamePanel = createPanel();
			JFrame window = createWindow(gamePanel);
			window.setVisible(true);
			Direction d;
			while(!getLabyrinthMap().isDone()) {
				gamePanel.repaint();
				d = keyListener.consumeDirection();
				getLabyrinthMap().updateMap(d);
				try {
					
					//para evitar de ficar bugado de dar atencao para o thread e para o progama
					//ao mesmo tempo, separamos esses 30 ms para dar atencao ao programa
					Thread.sleep(30);
					
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			JOptionPane.showMessageDialog(null, "Labirinto Completado!");
			window.dispose();
		} catch (IOException e) {
			System.out.println("nao foi possivel carregar as imagens");
		}
		
	}

}
