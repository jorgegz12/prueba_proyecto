
package clasepoo;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


// FrmVehiculo HEREDA de JFrame → es una ventana
public class FrmVehiculo extends JFrame {
 
    // ── Componentes del formulario (atributos globales) ────────────────────
    JLabel     lblTitulo = new JLabel("REGISTRO DE VEHÍCULO");
 
    JLabel     lblMarca  = new JLabel("Marca:");
    JTextField txtMarca  = new JTextField();
 
    JLabel     lblModelo = new JLabel("Modelo:");
    JTextField txtModelo = new JTextField();
 
    JLabel     lblAnio   = new JLabel("Año:");
    JTextField txtAnio   = new JTextField();
 
    JLabel     lblPrecio = new JLabel("Precio:");
    JTextField txtPrecio = new JTextField();
 
    JButton    btnGuardar = new JButton("Guardar");
 
    // ── Tabla para mostrar los vehículos guardados ─────────────────────────
    JTable            tablaVehiculos;
    DefaultTableModel modeloTabla;
    JScrollPane       scrollTabla;
 
    // ── ArrayList que guarda todos los vehículos creados ──────────────────
    private ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
 
    // ── Constructor ────────────────────────────────────────────────────────
    public FrmVehiculo() {
        configurarVentana();
        crearComponentes();
        configurarTabla();
        configurarBoton();
    }
 
    // Configuración básica de la ventana
    private void configurarVentana() {
        setTitle("Registro de Vehículo");
        setSize(520, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Centrar en pantalla
        setLayout(null);              // Posición manual con setBounds
    }
 
    // Crear y posicionar todos los componentes visuales
    // setBounds(x, y, ancho, alto)
    private void crearComponentes() {
        lblTitulo.setBounds(140, 15, 250, 30);
        add(lblTitulo);
 
        lblMarca.setBounds(30, 60, 110, 30);
        add(lblMarca);
        txtMarca.setBounds(145, 60, 200, 30);
        add(txtMarca);
 
        lblModelo.setBounds(30, 100, 110, 30);
        add(lblModelo);
        txtModelo.setBounds(145, 100, 200, 30);
        add(txtModelo);
 
        lblAnio.setBounds(30, 140, 110, 30);
        add(lblAnio);
        txtAnio.setBounds(145, 140, 200, 30);
        add(txtAnio);
 
        lblPrecio.setBounds(30, 180, 110, 30);
        add(lblPrecio);
        txtPrecio.setBounds(145, 180, 200, 30);
        add(txtPrecio);
 
        btnGuardar.setBounds(145, 225, 120, 35);
        add(btnGuardar);
    }
 
    // Configurar la tabla donde se muestran los vehículos guardados
    private void configurarTabla() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Marca");
        modeloTabla.addColumn("Modelo");
        modeloTabla.addColumn("Año");
        modeloTabla.addColumn("Precio (Q)");
 
        // La tabla se crea con el modelo que ya tiene las columnas
        tablaVehiculos = new JTable(modeloTabla);
 
        // JScrollPane envuelve la tabla para que tenga barra de desplazamiento
        scrollTabla = new JScrollPane(tablaVehiculos);
        scrollTabla.setBounds(30, 275, 450, 110);
        add(scrollTabla);
    }
 
    // Configurar el evento del botón Guardar
    private void configurarBoton() {
        btnGuardar.addActionListener(e -> guardarVehiculo());
    }
 
    // Lógica para guardar un vehículo
    private void guardarVehiculo() {
        try {
            // Leer los campos de texto
            String marca  = txtMarca.getText().trim();
            String modelo = txtModelo.getText().trim();
 
            // parseInt y parseDouble convierten String a número
            // Si el usuario escribe letras, lanza NumberFormatException
            int    anio   = Integer.parseInt(txtAnio.getText().trim());
            double precio = Double.parseDouble(txtPrecio.getText().trim());
 
            // Validar que marca y modelo no estén vacíos
            if (marca.isEmpty() || modelo.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Marca y Modelo no pueden estar vacíos.",
                    "Datos incompletos", JOptionPane.WARNING_MESSAGE);
                return;
            }
 
            // La llanta se crea con valores predeterminados
            // (no se piden en el formulario)
            Llanta llanta = new Llanta("Genérica", 15, 32.0);
 
            // Crear el objeto Vehiculo con todos los datos
            Vehiculo vehiculo = new Vehiculo(marca, modelo, anio, precio, llanta);
 
            // Agregar al ArrayList
            listaVehiculos.add(vehiculo);
 
            // Agregar una fila nueva a la tabla
            modeloTabla.addRow(new Object[]{
                vehiculo.getMarca(),
                vehiculo.getModelo(),
                vehiculo.getAnio(),
                vehiculo.getPrecio()
            });
 
            // Imprimir en consola también
            vehiculo.mostrarInformacion();
 
            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, "Vehículo guardado correctamente.");
 
            // Limpiar los campos para el siguiente ingreso
            limpiarCampos();
 
        } catch (NumberFormatException ex) {
            // Se ejecuta si Año o Precio tienen letras en vez de números
            JOptionPane.showMessageDialog(this,
                "Error: 'Año' debe ser un número entero y 'Precio' un número decimal.",
                "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    // Limpia todos los campos de texto después de guardar
    private void limpiarCampos() {
        txtMarca.setText("");
        txtModelo.setText("");
        txtAnio.setText("");
        txtPrecio.setText("");
        txtMarca.requestFocus();  // El cursor vuelve al primer campo
    }
}
