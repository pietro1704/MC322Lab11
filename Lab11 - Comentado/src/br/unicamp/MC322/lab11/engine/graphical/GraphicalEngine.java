package br.unicamp.MC322.lab11.engine.graphical;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;//acho que é para as imagens

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.unicamp.MC322.lab11.engine.GameEngine;
import br.unicamp.MC322.lab11.model.Direction;
import br.unicamp.MC322.lab11.model.LabyrinthMap;

public class GraphicalEngine extends GameEngine{

	//renderManager para desenho das imagens na tela
	private GraphicalRenderManager renderManager;
	
	//le entrada do teclado
	private GraphicalKeyListener keyListener;
	
	public GraphicalEngine(LabyrinthMap labyrinthMap) {
		super(labyrinthMap);
		this.renderManager = new GraphicalRenderManager();
		this.keyListener = new GraphicalKeyListener();
	}

	private JPanel createPanel() {
		JPanel panel = new JPanel() {
			/**
			 *			ISSO VEM POR CAUSA DO JPANEL 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				//ele sabe como pintar
				super.paintComponent(g);
				
				//faço um render do mapa
				renderManager.render(g, getLabyrinthMap());
			}
		};
		//para desenhar do tamanho do labirinto com imagens
		int width = getLabyrinthMap().getWidth() * GraphicalRenderManager.BLOCK_SIZE;
		int height = getLabyrinthMap().getHeight() * GraphicalRenderManager.BLOCK_SIZE;
		
		//tamanho da janela
		panel.setPreferredSize(new Dimension(width, height));
		return panel;
	}
	
	private JFrame createWindow(JPanel panel) {
		//cria janela
		JFrame window = new JFrame();
		window.add(panel);
		window.pack();
		
		window.setLocationRelativeTo(null);//desenhar no meio da tela do monitor
		window.addKeyListener(keyListener);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//programa fecha quando fecha a janela
		return window;
	}
	
	@Override
	public void gameLoop() {
		try {
			ImageLoder.getInstance().loadAllImg();
			JPanel gamePanel = createPanel();
			JFrame window = createWindow(gamePanel);
			window.setVisible(true);
			Direction d;
			
			while(!getLabyrinthMap().isDone()) {
				gamePanel.repaint();//redesenha
				d = keyListener.consumeDirection();//faz o movimento
				getLabyrinthMap().updateMap(d);
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			//jogo acabou
			JOptionPane.showMessageDialog(null, "Labirinto Completado!");
			window.dispose();//fecha a janela
			
		} catch (IOException e) {
			System.out.println("nao foi possivel carregar as imagens");
		}
		
	}

}
