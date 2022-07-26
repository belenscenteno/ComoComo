package Presentacion;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import Negocio.TransferUsuario;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

public class VentanaEditarPerfilRestaurante {

	private JFrame frame;
	private String usuario;
	private Controller ctrl;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblFoto;

	public VentanaEditarPerfilRestaurante(String usuario) {
		this.usuario = usuario;
		this.ctrl = Controller.getInstance();
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(234, 166, 93));
		frame.setBounds(100, 100, 500, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNombreDeUsuario = new JLabel("Usuario*");
		lblNombreDeUsuario.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNombreDeUsuario.setBounds(96, 169, 149, 20);
		frame.getContentPane().add(lblNombreDeUsuario);

		JLabel lblEmail = new JLabel("Email*");
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblEmail.setBounds(96, 207, 69, 20);
		frame.getContentPane().add(lblEmail);

		JLabel lblNombreRestaurante = new JLabel("Nombre*");
		lblNombreRestaurante.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNombreRestaurante.setBounds(96, 245, 149, 20);
		frame.getContentPane().add(lblNombreRestaurante);

		JLabel label = new JLabel("");
		label.setBounds(41, 270, 69, 20);
		frame.getContentPane().add(label);

		JButton btnInsertarMapaDe = new JButton("Insertar mapa de mesas");
		btnInsertarMapaDe.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnInsertarMapaDe.setBorderPainted(false);
		btnInsertarMapaDe.setOpaque(true);
		btnInsertarMapaDe.setBackground(Color.white);
		btnInsertarMapaDe.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnInsertarMapaDe.setBounds(42, 416, 220, 29);
		frame.getContentPane().add(btnInsertarMapaDe);

		JButton btnNewButton = new JButton("Cambiar contrasena");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(Color.white);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(41, 457, 220, 29);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Insertar menu");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setBackground(Color.white);
		btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBounds(41, 375, 220, 29);
		frame.getContentPane().add(btnNewButton_1);

		JLabel lblUbicacin = new JLabel("Ubicacion");
		lblUbicacin.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblUbicacin.setBounds(96, 283, 106, 20);
		frame.getContentPane().add(lblUbicacin);

		// CAMPOS DE TEXTO--> pedimos los datos de usuario:
		TransferUsuario t;
		try {
			t = ctrl.buscar(usuario, false);

			textField = new JTextField();
			textField.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			textField.setBorder(BorderFactory.createEmptyBorder());
			textField.setBounds(257, 167, 146, 26);
			textField.setText(usuario);
			textField.setToolTipText("Maximo 10 caracteres");
			frame.getContentPane().add(textField);
			textField.setColumns(10);

			textField_1 = new JTextField();
			textField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			textField_1.setBorder(BorderFactory.createEmptyBorder());
			textField_1.setBounds(257, 205, 146, 26);
			textField_1.setText(t.getEmail());
			textField_1.setToolTipText("Maximo 30 caracteres");
			frame.getContentPane().add(textField_1);
			textField_1.setColumns(10);

			textField_2 = new JTextField();
			textField_2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			textField_2.setBorder(BorderFactory.createEmptyBorder());
			textField_2.setBounds(257, 243, 146, 26);
			if (!t.getNombre().equals("null"))
				textField_2.setText(t.getNombre());
			textField_2.setToolTipText("Maximo 30 caracteres");
			frame.getContentPane().add(textField_2);
			textField_2.setColumns(10);

			textField_4 = new JTextField();
			textField_4.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			textField_4.setBorder(BorderFactory.createEmptyBorder());
			textField_4.setBounds(257, 281, 146, 26);
			if (!t.getUbicacion().equals("null"))
				textField_4.setText(t.getUbicacion());
			textField_4.setToolTipText("Maximo 50 caracteres");
			frame.getContentPane().add(textField_4);
			textField_4.setColumns(10);

			JLabel lblDescripcion = new JLabel("Descripcion");
			lblDescripcion.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			lblDescripcion.setBounds(96, 322, 106, 20);
			frame.getContentPane().add(lblDescripcion);

			textField_5 = new JTextField();
			textField_5.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			textField_5.setBorder(BorderFactory.createEmptyBorder());
			textField_5.setBounds(257, 319, 146, 29);
			if (!t.getDescripcion().equals("null"))
				textField_5.setText(t.getDescripcion());
			textField_5.setToolTipText("Maximo 100 caracteres");
			frame.getContentPane().add(textField_5);
			textField_5.setColumns(10);
		} catch (Exception e) {}

		JButton btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnGuardarCambios.setBorderPainted(false);
		btnGuardarCambios.setOpaque(true);
		btnGuardarCambios.setBackground(Color.white);
		btnGuardarCambios.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnGuardarCambios.setBounds(122, 551, 255, 45);
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("") || textField_1.getText().equals("")|| 
						textField_2.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Alguno de los campos obligatorios esta vacio", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						ctrl.guardarCambiosRest(usuario, textField.getText(), textField_1.getText(),
								textField_2.getText(), textField_4.getText(), textField_5.getText());
						usuario = textField.getText();// actualizo el nuevo usuario
					} catch (Exception a) {
						JOptionPane.showMessageDialog(frame, a.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					frame.setVisible(false);
					VentanaPerfilRestaurante ventana = new VentanaPerfilRestaurante(usuario);
				}
			}
		});
		frame.getContentPane().add(btnGuardarCambios);

		JButton btnNewButton_11 = new JButton();
		btnNewButton_11.setBackground(new Color(234, 166, 93));
		btnNewButton_11.setBounds(222, 624, 56, 41);
		btnNewButton_11.setBorderPainted(false);
		btnNewButton_11.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ImageIcon icono1 = new javax.swing.ImageIcon(VentanaIni.class.getResource("/Resources/return.png"));
		Image imagen1 = icono1.getImage();
		ImageIcon iconoEsc1 = new ImageIcon(imagen1.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		btnNewButton_11.setIcon(iconoEsc1);
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				VentanaPerfilRestaurante inicioSesion = new VentanaPerfilRestaurante(usuario);
			}
		});
		frame.getContentPane().add(btnNewButton_11);

		JButton btnNewButton_2 = new JButton("Borrar cuenta");
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setOpaque(true);
		btnNewButton_2.setBackground(Color.white);
		btnNewButton_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ctrl.eliminarCuenta(usuario, false);
					frame.setVisible(false);
					VentanaPrincipal principal = new VentanaPrincipal();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(41, 498, 221, 29);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnElegirImagenMenu = new JButton("Imagen perfil");
		btnElegirImagenMenu.setToolTipText("Elige la imagen de perfil");
		btnElegirImagenMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnElegirImagenMenu.setBorderPainted(false);
		btnElegirImagenMenu.setOpaque(true);
		btnElegirImagenMenu.setBackground(Color.white);
		btnElegirImagenMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnElegirImagenMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser f = new JFileChooser();
				int ret = f.showOpenDialog(frame);
				try {
					if (ret == JFileChooser.APPROVE_OPTION) {
						ctrl.guardarImagen(f.getSelectedFile(), usuario);
						Image im = ImageIO.read(new FileInputStream(f.getSelectedFile()));
						ImageIcon iconoEsc=new ImageIcon(im.getScaledInstance(130, 100, Image.SCALE_SMOOTH));
						lblFoto.setIcon(iconoEsc);
					}
				} catch (IllegalArgumentException ie) {
					JOptionPane.showMessageDialog(frame, ie.getMessage(), "Invalid file", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame,
							"You chose an invalid file. The file must contain a JSON Object", "Invalid file",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnElegirImagenMenu.setBounds(274, 480, 163, 47);
		frame.getContentPane().add(btnElegirImagenMenu);
		
		lblFoto = new JLabel("");
		lblFoto.setBounds(277, 375, 160, 96);
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		Image imagen= ctrl.getImagen(usuario);
		if (imagen != null) {
			ImageIcon iconoEsc=new ImageIcon(imagen.getScaledInstance(270, 180, Image.SCALE_SMOOTH));
			lblFoto.setIcon(iconoEsc);
		}
		frame.getContentPane().add(lblFoto);
		
		JLabel lblNewLabel = new JLabel();
		ImageIcon icono=new javax.swing.ImageIcon(VentanaIni.class.getResource("/Resources/Negrosinfondo.png"));
		Image imagen11=icono.getImage();
		ImageIcon iconoEsc=new ImageIcon(imagen11.getScaledInstance(100,100, Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(iconoEsc);
		lblNewLabel.setBounds(200, 18, 100, 113);
		frame.getContentPane().add(lblNewLabel);
	}
}
		
