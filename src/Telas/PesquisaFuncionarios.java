/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author alysson
 */
public class PesquisaFuncionarios extends javax.swing.JFrame {
private Connection connection= null;
    private  Statement stm=null;
    public ResultSet rs=null;
    /**
     * Creates new form PesquisaFuncionarios
     */
    public PesquisaFuncionarios() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Deletar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
int valor;
String ID;
         String driver="com.mysql.jdbc.Driver";
    String servidor="jdbc:mysql://localhost:3306/escolaOnline";
    String usuario="root";
    String senha="";
    
    try{
    Class.forName(driver);
    this.connection=DriverManager.getConnection(servidor,usuario,senha);
    this.stm=this.connection.createStatement();
    
    }catch(Exception e){
    System.out.println("Erro "+e);
    }
    
    valor=Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para Pesquisar Tudo\n 2 Para Pesquisar Por ID"));
    if(valor==1){
  
    try{
		String tabela="SELECT * FROM funcionarios";	
		this.rs=stm.executeQuery(tabela);	
		this.stm=this.connection.createStatement();
		
                while(this.rs.next()){
                    String id=rs.getString("id");
                    String nome=rs.getString("nome");
                    String cargo=rs.getString("cargo");
                   txtResultado.append("ID: "+id+"| Nome: "+nome+"| Cargo: "+cargo+"\n");
                
               
		}
		}catch(Exception e){
			System.out.println("erro na coluna");
			
		}	

    }else 
    if(valor==2){
        ID=JOptionPane.showInputDialog("Qual o ID");
        try{
		String tabela="SELECT * FROM funcionarios WHERE id IN('"+ID+"')";	
		this.rs=stm.executeQuery(tabela);	
		this.stm=this.connection.createStatement();
		
                while(this.rs.next()){
                    String id=rs.getString("id");
                    String nome=rs.getString("nome");
                    String cargo=rs.getString("cargo");
                   txtResultado.append("ID: "+id+"| Nome: "+nome+"| Cargo: "+cargo+"\n");
                
               
		}
		}catch(Exception e){
			System.out.println("erro na coluna");
			
		}	    
            
            }




// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
String nome,cargo,id,tel,titulo,rg,cpf;
         String driver="com.mysql.jdbc.Driver";
    String servidor="jdbc:mysql://localhost:3306/escolaOnline";
    String usuario="root";
    String senha="";
    
    try{
    Class.forName(driver);
    this.connection=DriverManager.getConnection(servidor,usuario,senha);
    this.stm=this.connection.createStatement();
    
    }catch(Exception e){
    System.out.println("Erro "+e);
    }
    
    id=JOptionPane.showInputDialog("Informe o ID");
    nome=JOptionPane.showInputDialog("Informe o nome");
    cargo=JOptionPane.showInputDialog("Informe o cargo");
    tel=JOptionPane.showInputDialog("Informe o telefone");
    titulo=JOptionPane.showInputDialog("Informe o titulo");
    rg=JOptionPane.showInputDialog("Informe o RG");
    cpf=JOptionPane.showInputDialog("Informe o CPF");
    try{
		String tabela="UPDATE funcionarios SET nome='"+nome+"', cargo='"+cargo+"', cpf='"+cpf+"', rg='"+rg+"', tituliEl='"+titulo+"', telefone='"+tel+"'WHERE id="+id+";";	
		this.stm.executeUpdate(tabela);	
			
		}catch(Exception e){
			System.out.println("erro na edição: "+e.getMessage());
			
		}	


txtResultado.append("");

// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    String ID;
    String driver="com.mysql.jdbc.Driver";
    String servidor="jdbc:mysql://localhost:3306/escolaOnline";
    String usuario="root";
    String senha="";
    
    try{
    Class.forName(driver);
    this.connection=DriverManager.getConnection(servidor,usuario,senha);
    this.stm=this.connection.createStatement();
    
    }catch(Exception e){
    System.out.println("Erro "+e);
    }   
    ID=JOptionPane.showInputDialog("Informe o ID");
try{
		String tabela="DELETE FROM funcionarios WHERE id='"+ID+"';";	
		this.stm.executeUpdate(tabela);	
			
		}catch(Exception e){
			System.out.println("erro na edição: "+e.getMessage());
			
		}	






txtResultado.append("");




// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(PesquisaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaFuncionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}