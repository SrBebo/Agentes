//tener en cuenta que no es todo el codigo xq la GUI lleva mucho codigo 
package agentesc;

public class GUIExample1 extends javax.swing.JFrame {

    
    public GUIExample1() {
        initComponents();
    }
    
    public String[] getCarro() {
        return carro;
    }
  
  
  
private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        carro[0] = txtModel_name.getText();
        carro[1] = txtTransmission.getText();
        carro[2] = txtOdometer_value.getText();
        carro[3] = txtYear_produced.getText();
        carro[4] = txtEngine_capacity.getText();
        carro[5] = txtBody_type.getText();
        carro[6] = txtHas_warranty.getText();
        carro[7] = txtDrivetrain.getText();
        carro[8] = txtFeature_0.getText();
        carro[9] = txtFeature_1.getText();
        carro[10] = txtFeature_2.getText();
        carro[11] = txtFeature_3.getText();
        carro[12] = txtFeature_4.getText();
        carro[13] = txtFeature_5.getText();
        carro[14] = txtFeature_6.getText();
        carro[15] = txtFeature_7.getText();
        carro[16] = txtFeature_8.getText();
        carro[17] = txtFeature_9.getText();
        btnEnviarDC.setEnabled(true);
        btnLimpiarC.setEnabled(true);
    }                                           

    private void btnEnviarDCActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        ispressBotonCliente = pressBoton();
        btnEnviarDC.setEnabled(false);
        btnGuardarC.setEnabled(false);
    }                                           

    private void btnLimpiarCActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        txtModel_name.setText(null);
        txtTransmission.setText(null);
        txtOdometer_value.setText(null);
        txtYear_produced.setText(null);
        txtEngine_capacity.setText(null);
        txtBody_type.setText(null);
        txtHas_warranty.setText(null);
        txtDrivetrain.setText(null);
        txtFeature_0.setText(null);
        txtFeature_1.setText(null);
        txtFeature_2.setText(null);
        txtFeature_3.setText(null);
        txtFeature_4.setText(null);
        txtFeature_5.setText(null);
        txtFeature_6.setText(null);
        txtFeature_7.setText(null);
        txtFeature_8.setText(null);
        txtFeature_9.setText(null);
    }                                           

    private boolean ispressBotonCliente;
    private boolean ispressBotonPagosVentas;
    
    private boolean pressBoton(){
        return true;
    }
    public boolean isIspressBotonCliente(){
        return ispressBotonCliente;
    }
    
    public boolean isIspressBotonPagosVentas(){
        return ispressBotonPagosVentas;
    }
    
    public void setIspressBotonCliente(boolean ispressBotonCliente){
        this.ispressBotonCliente = ispressBotonCliente;
    }
    
    public void setIspressBotonPagosVentas(boolean ispressBotonPagosVentas){
        this.ispressBotonPagosVentas = ispressBotonPagosVentas;
    }
