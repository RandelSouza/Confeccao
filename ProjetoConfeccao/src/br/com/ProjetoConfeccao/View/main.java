/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoConfeccao.View;

import br.com.ProjetoConfeccao.Dao.DaoFuncionario;
import br.com.ProjetoConfeccao.Dao.DaoTipo;
import br.com.ProjetoConfeccao.Pojo.Funcionario;
import br.com.ProjetoConfeccao.Pojo.Tipo;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author randel
 */
public class main extends javax.swing.JFrame {
    boolean t = true;
    boolean f = false;    
    Locale locale = new Locale("pt", "BR");
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
    DecimalFormat formato = new DecimalFormat("R$ #,##0.00");             
    double valorDiario = 0.0;   
    DaoFuncionario daoFuncionario = new DaoFuncionario();
    Funcionario funcionarioPojo = new Funcionario();
    DaoTipo daoTipo = new DaoTipo();
    Tipo tipoPojo = new Tipo();
    int flagTipo = 0;
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * Creates new form form_funcionario
     */
    public main() {       
       setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza a janela (full size) de acordo com o tamanho da tela.               
       //setExtendedState(JFrame.MAXIMIZED_HORIZ);
      // setResizable(f);
       initComponents();
       setIconImage(new ImageIcon(getClass().getResource("/com/jtattoo/plaf/texture/patterns/snow/window_texture.jpg")).getImage()); // mudar para o logotipo referente a empresa.                        
       daoFuncionario.buscarTipos(jComboBoxTipoFuncionario, jComboBox1, jComboBoxIdTipoFuncionario);
       daoFuncionario.buscarTipos(jComboBoxEditarTipoFuncionario, jComboBoxDescricaoEditarTipoFuncionario, jComboBoxIdEditarTipoFuncionario);
       
       if(jComboBox1.getItemCount() != 0){
           jTextAreaFuncaoFuncionario.setText(jComboBox1.getItemAt(0));
       }
       if( jComboBoxDescricaoEditarTipoFuncionario.getItemCount() != 0){
           jTextAreaEditarFuncaoFuncionario.setText( jComboBoxDescricaoEditarTipoFuncionario.getItemAt(0));
       }
        //jTabbedPane3.setVisible(f);
       daoTipo.preencherTabela(jTableTipo);       
       daoFuncionario.preencherTabela(jTableFuncionario);
       daoFuncionario.preencherTabela(jTableFuncionario2);
    }

    // Tem a função de habilitar ou desabilitar os campos referentes aos formulários do funcionários.
    private void habilitarCampos(int nome, int masculino, int feminino, int idade, int cpf, 
                              int rua, int bairro, int valorDiaria, int telefone1, int telefone2,
                              int tipo, int salario, int dataNascimento, int diasUteis){
        
        
        // Campo nome do funcionário
        if(nome == 1){
            jTextFieldNomeFuncionario.setEnabled(t);
        }else{
            jTextFieldNomeFuncionario.setEnabled(f);
        }
        
        // Campo masculino
        if(masculino == 1){
            jRadioButtonMasculinoFuncionario.setEnabled(t);
        }else{
            jRadioButtonMasculinoFuncionario.setEnabled(f);
        }
        
        // Campo feminino                
        if(masculino == 1){
            jRadioButtonFemininoFuncionario.setEnabled(t);
        }else{
            jRadioButtonFemininoFuncionario.setEnabled(f);
        }
        
        // Campo idade
        if(idade == 1){
            jTextFieldIdadeFuncionario.setEnabled(t);
        }else{
            jTextFieldIdadeFuncionario.setEnabled(f);
        }
        
        // Campo cpf
        if(cpf == 1){
            jTextFieldCpfFuncionario.setEnabled(t);
        }else{
            jTextFieldCpfFuncionario.setEnabled(f);
        }
        
        // Campo rua
        if(rua == 1){
            jTextFieldRuaFuncionario.setEnabled(t);
        }else{
            jTextFieldRuaFuncionario.setEnabled(f);
        }
        
        // Campo bairro
        if(bairro == 1){
            jTextFieldBairroFuncionario.setEnabled(t);
        }else{
            jTextFieldBairroFuncionario.setEnabled(f);
        }
        
        // Campo Valor_da_diaria
        if(valorDiaria == 1){
           jFormattedTextFieldValorDiariaFuncionario.setEnabled(t);
        }else{
           jFormattedTextFieldValorDiariaFuncionario.setEnabled(f);
        }
        
         // Campo telefone 1
        if(telefone1 == 1){
            jTextFieldTelefone1Funcionario.setEnabled(t);
        }else{
            jTextFieldTelefone1Funcionario.setEnabled(f);
        }
        
        // Campo telefone 2
        if(telefone2 == 1){
            jTextFieldTelefone2Funcionario.setEnabled(t);
        }else{
            jTextFieldTelefone2Funcionario.setEnabled(f);
        }
        
        // Campo tipo
        if(tipo == 1){
            jComboBoxTipoFuncionario.setEnabled(t);
        }else{
            jComboBoxTipoFuncionario.setEnabled(f);        
        }
        
        // Campo salario
        if(salario == 1){
            jTextFieldSalarioFuncionario.setEnabled(t);
        }else{
            jTextFieldSalarioFuncionario.setEnabled(f);        
        }

        // Campo data de nascimento
        if(dataNascimento == 1){
            jTextFieldDataNascimentoFuncionario.setEnabled(t);
        }else{
            jTextFieldDataNascimentoFuncionario.setEnabled(f);        
        }        
        
        // Campo dias uteis
        if(diasUteis == 1){
            jTextFielDiasUteisFuncionario.setEnabled(t);
        }else{
            jTextFielDiasUteisFuncionario.setEnabled(f);        
        }        
    }
    
    private void habilitarCamposEditar(int nome, int masculino, int feminino, int idade, int cpf, 
                              int rua, int bairro, int valorDiaria, int telefone1, int telefone2,
                              int tipo, int salario, int dataNascimento, int diasUteis){
        
        
        // Campo nome do funcionário
        if(nome == 1){
            jTextFieldEditarNomeFuncionario.setEnabled(t);
        }else{
            jTextFieldEditarNomeFuncionario.setEnabled(f);
        }
        
        // Campo masculino
        if(masculino == 1){
            jRadioButtonEditarMasculinoFuncionario.setEnabled(t);
        }else{
            jRadioButtonEditarMasculinoFuncionario.setEnabled(f);
        }
        
        // Campo feminino                
        if(masculino == 1){
            jRadioButtonEditarFemininoFuncionario.setEnabled(t);
        }else{
            jRadioButtonEditarFemininoFuncionario.setEnabled(f);
        }
        
        // Campo idade
        if(idade == 1){
            jTextFieldEditarIdadeFuncionario.setEnabled(t);
        }else{
            jTextFieldEditarIdadeFuncionario.setEnabled(f);
        }
        
        // Campo cpf
        if(cpf == 1){
            jTextFieldEditarCpfFuncionario.setEnabled(t);
        }else{
            jTextFieldEditarCpfFuncionario.setEnabled(f);
        }
        
        // Campo rua
        if(rua == 1){
            jTextFieldEditarRuaFuncionario.setEnabled(t);
        }else{
            jTextFieldEditarRuaFuncionario.setEnabled(f);
        }
        
        // Campo bairro
        if(bairro == 1){
            jTextFieldEditarBairroFuncionario.setEnabled(t);
        }else{
            jTextFieldEditarBairroFuncionario.setEnabled(f);
        }
        
        // Campo Valor_da_diaria
        if(valorDiaria == 1){
           jFormattedTextFieldEditarValorDiariaFuncionario.setEnabled(t);
        }else{
           jFormattedTextFieldEditarValorDiariaFuncionario.setEnabled(f);
        }
        
         // Campo telefone 1
        if(telefone1 == 1){
            jTextFieldEditarTelefone1Funcionario.setEnabled(t);
        }else{
            jTextFieldEditarTelefone1Funcionario.setEnabled(f);
        }
        
        // Campo telefone 2
        if(telefone2 == 1){
            jTextFieldEditarTelefone2Funcionario.setEnabled(t);
        }else{
            jTextFieldEditarTelefone2Funcionario.setEnabled(f);
        }
        
        // Campo tipo
        if(tipo == 1){
            jComboBoxEditarTipoFuncionario.setEnabled(t);
        }else{
            jComboBoxEditarTipoFuncionario.setEnabled(f);        
        }
        
        // Campo salario
        if(salario == 1){
            jTextFieldEditarSalarioFuncionario.setEnabled(t);
        }else{
            jTextFieldEditarSalarioFuncionario.setEnabled(f);        
        }

        // Campo data de nascimento
        if(dataNascimento == 1){
            jTextFieldEditarDataNascimentoFuncionario.setEnabled(t);
        }else{
            jTextFieldEditarDataNascimentoFuncionario.setEnabled(f);        
        }        
        
        // Campo dias uteis
        if(diasUteis == 1){
            jTextFielEditarDiasUteisFuncionario.setEnabled(t);
        }else{
            jTextFielEditarDiasUteisFuncionario.setEnabled(f);        
        }        
    }
    
    // Habilita ou desabilita os botões referentes ao painel de formularios de Funcionários.
    private void habilitarBotoes(int novo, int salvar, int cancelar){
        
        // Botão novo
        if(novo == 1){
            jButtonNovo.setEnabled(t);
        }else{
            jButtonNovo.setEnabled(f);
        }
                        
        // Botão salvar
        if(salvar == 1){
            jButtonSalvarFuncionario.setEnabled(t);
        }else{
            jButtonSalvarFuncionario.setEnabled(f);
        }
        
        // Botão cancelar
        if(cancelar == 1){
            jButtonCancelarFuncionario.setEnabled(t);
        }else{
            jButtonCancelarFuncionario.setEnabled(f);
        }
        
    }
    
    // Habilita ou desabilita os campos referentes ao formulario das funções dos Funcionários.
    private void habilitarCamposTipo(int nome, int descricao){
        // Nome do tipo de funcionalidade
        if(nome == 1){
            jTextFieldNomeDoTipo.setEnabled(t);
        }else{
            jTextFieldNomeDoTipo.setEnabled(f);
        }
        
        // Descrição do tipo de funcionalidade
        if(descricao == 1){
            jTextAreaDescricaoDoTipo.setEnabled(t);
        }else{
            jTextAreaDescricaoDoTipo.setEnabled(f);
        }
    }
    
    // Habilita ou não os botões presentes no formulario de tipo de função do funcionário.
    private void habilitarBotoesTipo(int novo, int salvar, int cancelar, int editar, int excluir){
        // Botão novo tipo de funcionário
        if(novo == 1){
            jButtonNovoTipo.setEnabled(t);
        }else{
            jButtonNovoTipo.setEnabled(f);
        }
        
        // Botão salvar o tipo de funcionário
        if(salvar == 1){
            jButtonSalvarTipo.setEnabled(t);
        }else{
            jButtonSalvarTipo.setEnabled(f);
        }
        
        // Botão cancelar tipo de funcionário
        if(cancelar == 1){
            jButtonCancelarTipo.setEnabled(t);
        }else{
            jButtonCancelarTipo.setEnabled(f);
        }
        
        // Botão editar tipo de funcionário
        if(editar == 1){
            jButtonEditarTipo.setEnabled(t);
        }else{
            jButtonEditarTipo.setEnabled(f);
        }
        
        // Botão excluir tipo de funcionário
        if(excluir == 1){
            jButtonExcluirTipo.setEnabled(t);
        }else{
            jButtonExcluirTipo.setEnabled(f);
        }
    }
    
    private void habilitarBotoesEditar(int editar, int salvar, int cancelar, int excluir){
        if(editar == 1){
            jButtonEditarEditarFuncionario.setEnabled(t);
        }else{
            jButtonEditarEditarFuncionario.setEnabled(f);
        }
        
        if(salvar == 1){
            jButtonEditarSalvarFuncionario.setEnabled(t);
        }else{
            jButtonEditarSalvarFuncionario.setEnabled(f);
        }
        
        if(cancelar == 1){
            jButtonEditarCancelarFuncionario.setEnabled(t);
        }else{
            jButtonEditarCancelarFuncionario.setEnabled(f);
        }
        
        if(excluir == 1){
            jButtonEditarExcluirFuncionario.setEnabled(t);
        }else{
            jButtonEditarExcluirFuncionario.setEnabled(f);
        }
        
    }
    // Limpa todos os campos do formulario de tipos de função.
    private void limparCamposTipo(){
        jTextFieldNomeDoTipo.setText("");
        jTextAreaDescricaoDoTipo.setText("");
        jTextFieldIdTipo.setText("");
        jTableTipo.clearSelection();
        
    }
    
    // Limpa todos os campos do formulário de funcionarios.
    private void limparCampos(){
        jTextFieldNomeFuncionario.setText("");
        jRadioButtonMasculinoFuncionario.setSelected(f);
        jRadioButtonFemininoFuncionario.setSelected(t);
        jTextFieldIdadeFuncionario.setText("");
        jTextFieldCpfFuncionario.setText("");
        jTextFieldRuaFuncionario.setText("");
        jTextFieldBairroFuncionario.setText("");
        jFormattedTextFieldValorDiariaFuncionario.setText("");
        jTextFieldTelefone1Funcionario.setText("");
        jTextFieldTelefone2Funcionario.setText("");
        jComboBoxTipoFuncionario.setSelectedIndex(0);
        jTextFieldSalarioFuncionario.setText("");
        jTextFieldDataNascimentoFuncionario.setDate(null);
        jTextFielDiasUteisFuncionario.setText("");
    }
    
    private void limparCamposEditar(){        
        jTextFieldEditarIdentificadorFuncionario.setText("");                
        jTextFieldEditarNomeFuncionario.setText("");                               
        jRadioButtonEditarMasculinoFuncionario.setSelected(f);                        
        jRadioButtonEditarFemininoFuncionario.setSelected(f);                                
        jTextFieldEditarIdadeFuncionario.setText("");                                
        jTextFieldEditarCpfFuncionario.setText("");                
        jTextFieldEditarRuaFuncionario.setText("");                        
        jTextFieldEditarBairroFuncionario.setText("");                                
        jFormattedTextFieldEditarValorDiariaFuncionario.setText("");                         
        jTextFieldEditarTelefone1Funcionario.setText("");                                
        jTextFieldEditarTelefone2Funcionario.setText("");                                
        jComboBoxEditarTipoFuncionario.setSelectedIndex(0);                                
        jTextFieldEditarSalarioFuncionario.setText("");                
        jTextFieldEditarDataNascimentoFuncionario.setDate(null);                       
        jTextFielEditarDiasUteisFuncionario.setText("");        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jCheckBoxFuncionarioPontoNao = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel58 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel59 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jDateChooserPonto = new com.toedter.calendar.JDateChooser();
        jLabel64 = new javax.swing.JLabel();
        jCheckBoxFuncionarioPontoSim = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel65 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel66 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButtonPontoAdicionarSalvar = new javax.swing.JButton();
        jButtonPontoAdicionarCancelar = new javax.swing.JButton();
        jButtonPontoAdicionarNovo = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jTabbedPaneFuncionario = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNomeFuncionario = new javax.swing.JTextField();
        jRadioButtonMasculinoFuncionario = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jRadioButtonFemininoFuncionario = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldIdadeFuncionario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldRuaFuncionario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldBairroFuncionario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxTipoFuncionario = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButtonCancelarFuncionario = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonSalvarFuncionario = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextFielDiasUteisFuncionario = new javax.swing.JTextField();
        jTextFieldDataNascimentoFuncionario = new com.toedter.calendar.JDateChooser();
        jFormattedTextFieldValorDiariaFuncionario = new javax.swing.JFormattedTextField();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaFuncaoFuncionario = new javax.swing.JTextArea();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jTextFieldCpfFuncionario = new javax.swing.JFormattedTextField();
        jComboBoxIdTipoFuncionario = new javax.swing.JComboBox<>();
        jTextFieldTelefone1Funcionario = new javax.swing.JFormattedTextField();
        jTextFieldTelefone2Funcionario = new javax.swing.JFormattedTextField();
        jTextFieldSalarioFuncionario = new javax.swing.JFormattedTextField();
        jLabel28 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jTextFieldEditarNomeFuncionario = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jRadioButtonEditarMasculinoFuncionario = new javax.swing.JRadioButton();
        jRadioButtonEditarFemininoFuncionario = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldEditarIdadeFuncionario = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldEditarDataNascimentoFuncionario = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextFieldEditarRuaFuncionario = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldEditarBairroFuncionario = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jFormattedTextFieldEditarValorDiariaFuncionario = new javax.swing.JFormattedTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextFielEditarDiasUteisFuncionario = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jComboBoxEditarTipoFuncionario = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jTextFieldEditarSalarioFuncionario = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableFuncionario2 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextAreaEditarFuncaoFuncionario = new javax.swing.JTextArea();
        jTextFieldEditarIdentificadorFuncionario = new javax.swing.JTextField();
        jTextFieldEditarCpfFuncionario = new javax.swing.JFormattedTextField();
        jTextFieldEditarTelefone1Funcionario = new javax.swing.JFormattedTextField();
        jTextFieldEditarTelefone2Funcionario = new javax.swing.JFormattedTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButtonEditarEditarFuncionario = new javax.swing.JButton();
        jButtonEditarCancelarFuncionario = new javax.swing.JButton();
        jComboBoxIdEditarTipoFuncionario = new javax.swing.JComboBox<>();
        jComboBoxDescricaoEditarTipoFuncionario = new javax.swing.JComboBox<>();
        jButtonEditarSalvarFuncionario = new javax.swing.JButton();
        jButtonEditarExcluirFuncionario = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFuncionario = new javax.swing.JTable();
        jLabel39 = new javax.swing.JLabel();
        jLabelVisualizarNomeFuncionario = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabelVisualizarSexoFuncionario = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabelVisualizarIdadeFuncionario = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabelVisualizarDataNascimentoFuncionario = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabelVisualizarCpfFuncionario = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabelVisualizarRuaFuncionario = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabelVisualizarBairroFuncionario = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabelVisualizarValorDiariaFuncionario = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabelVisualizarPeriodoDiasUteisFuncionario = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabelVisualizarTelefone1Funcionario = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabelVisualizarTelefone2Funcionario = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabelVisualizarFuncaoFuncionario = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabelVisualizarSalarioFuncionario = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabelVisualizarIdentificadorFuncionario = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jLabelVisualizarDescricaoFuncionario = new javax.swing.JTextArea();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTextFieldIdTipo = new javax.swing.JTextField();
        jTextFieldNomeDoTipo = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaDescricaoDoTipo = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableTipo = new javax.swing.JTable();
        jButtonSalvarTipo = new javax.swing.JButton();
        jButtonNovoTipo = new javax.swing.JButton();
        jButtonEditarTipo = new javax.swing.JButton();
        jButtonExcluirTipo = new javax.swing.JButton();
        jButtonCancelarTipo = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jCheckBoxFuncionarioPontoNao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setText("Identificador: ");
        jCheckBoxFuncionarioPontoNao.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, -1));

        jTextField1.setEnabled(false);
        jCheckBoxFuncionarioPontoNao.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 71, -1));

        jLabel57.setText("Funcionário: ");
        jCheckBoxFuncionarioPontoNao.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setEnabled(false);
        jCheckBoxFuncionarioPontoNao.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 380, -1));

        jLabel58.setText("Extra: ");
        jCheckBoxFuncionarioPontoNao.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.setEnabled(false);
        jCheckBoxFuncionarioPontoNao.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 164, -1));

        jLabel59.setText("1° Entrada: ");
        jCheckBoxFuncionarioPontoNao.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, -1, -1));

        jTextField2.setEnabled(false);
        jCheckBoxFuncionarioPontoNao.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, 135, -1));

        jLabel60.setText("1° Saída: ");
        jCheckBoxFuncionarioPontoNao.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 130, 66, -1));

        jTextField3.setEnabled(false);
        jCheckBoxFuncionarioPontoNao.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 130, 140, -1));

        jLabel61.setText("2° Entrada: ");
        jCheckBoxFuncionarioPontoNao.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, -1, -1));

        jTextField4.setEnabled(false);
        jCheckBoxFuncionarioPontoNao.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 170, 135, -1));

        jLabel62.setText("2° Saída: ");
        jCheckBoxFuncionarioPontoNao.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 180, 66, -1));

        jTextField5.setEnabled(false);
        jCheckBoxFuncionarioPontoNao.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 170, 140, -1));

        jLabel63.setText("Data: ");
        jCheckBoxFuncionarioPontoNao.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        jDateChooserPonto.setEnabled(false);
        jCheckBoxFuncionarioPontoNao.add(jDateChooserPonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, -1));

        jLabel64.setText("Falta: ");
        jCheckBoxFuncionarioPontoNao.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, -1, -1));

        jCheckBoxFuncionarioPontoSim.setText("Sim");
        jCheckBoxFuncionarioPontoSim.setEnabled(false);
        jCheckBoxFuncionarioPontoSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxFuncionarioPontoSimActionPerformed(evt);
            }
        });
        jCheckBoxFuncionarioPontoNao.add(jCheckBoxFuncionarioPontoSim, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 210, -1, -1));

        jCheckBox2.setText("Não");
        jCheckBox2.setEnabled(false);
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jCheckBoxFuncionarioPontoNao.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 210, -1, -1));

        jLabel65.setText("Justificatva da Falta: ");
        jCheckBoxFuncionarioPontoNao.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane8.setViewportView(jTextArea1);

        jCheckBoxFuncionarioPontoNao.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 260, 360, -1));

        jLabel66.setText("Valor da Falta: ");
        jCheckBoxFuncionarioPontoNao.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 220, -1, -1));

        jTextField6.setEnabled(false);
        jCheckBoxFuncionarioPontoNao.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 220, 130, -1));

        jButton1.setText("Data Atual");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jCheckBoxFuncionarioPontoNao.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, -1, -1));

        jButtonPontoAdicionarSalvar.setText("Salvar");
        jButtonPontoAdicionarSalvar.setEnabled(false);
        jCheckBoxFuncionarioPontoNao.add(jButtonPontoAdicionarSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 530, 173, 47));

        jButtonPontoAdicionarCancelar.setText("Cancelar");
        jButtonPontoAdicionarCancelar.setEnabled(false);
        jCheckBoxFuncionarioPontoNao.add(jButtonPontoAdicionarCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 530, 173, 47));

        jButtonPontoAdicionarNovo.setText("Novo");
        jButtonPontoAdicionarNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPontoAdicionarNovoActionPerformed(evt);
            }
        });
        jCheckBoxFuncionarioPontoNao.add(jButtonPontoAdicionarNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, 173, 47));

        jTabbedPane2.addTab("Adicionar", jCheckBoxFuncionarioPontoNao);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1350, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Visualizar", jPanel5);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1350, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Editar", jPanel7);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1350, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Exluir", jPanel8);

        jTabbedPane1.addTab("Ponto", jTabbedPane2);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulário de Preenchimento de Dados do Funcionário"));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 790, 50));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setEnabled(false);
        jPanel9.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Nome: ");
        jPanel9.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 123, 80, 30));

        jTextFieldNomeFuncionario.setEnabled(false);
        jTextFieldNomeFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeFuncionarioActionPerformed(evt);
            }
        });
        jPanel9.add(jTextFieldNomeFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 201, -1));

        jRadioButtonMasculinoFuncionario.setText("Masculino");
        jRadioButtonMasculinoFuncionario.setEnabled(false);
        jRadioButtonMasculinoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMasculinoFuncionarioActionPerformed(evt);
            }
        });
        jPanel9.add(jRadioButtonMasculinoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 97, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Sexo: ");
        jPanel9.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 90, 20));

        jRadioButtonFemininoFuncionario.setSelected(true);
        jRadioButtonFemininoFuncionario.setText("Feminino");
        jRadioButtonFemininoFuncionario.setEnabled(false);
        jRadioButtonFemininoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFemininoFuncionarioActionPerformed(evt);
            }
        });
        jPanel9.add(jRadioButtonFemininoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 102, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Idade: ");
        jPanel9.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 90, 20));

        jTextFieldIdadeFuncionario.setEnabled(false);
        jTextFieldIdadeFuncionario.setName("jTextFieldIdadeFuncionario"); // NOI18N
        jTextFieldIdadeFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldIdadeFuncionarioKeyTyped(evt);
            }
        });
        jPanel9.add(jTextFieldIdadeFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 200, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("CPF: ");
        jPanel9.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(516, 130, 70, 20));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Rua: ");
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(516, 190, 80, 20));

        jTextFieldRuaFuncionario.setEnabled(false);
        jPanel9.add(jTextFieldRuaFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 230, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Bairro: ");
        jPanel9.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 240, 90, 20));

        jTextFieldBairroFuncionario.setEnabled(false);
        jPanel9.add(jTextFieldBairroFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 230, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Telefone (1): ");
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(966, 130, 110, 20));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Telefone (2):");
        jPanel9.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(963, 190, 110, 20));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Função: ");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(982, 244, 70, 20));

        jComboBoxTipoFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxTipoFuncionario.setEnabled(false);
        jComboBoxTipoFuncionario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTipoFuncionarioItemStateChanged(evt);
            }
        });
        jComboBoxTipoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoFuncionarioActionPerformed(evt);
            }
        });
        jPanel9.add(jComboBoxTipoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 240, 245, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Data de Nascimento:");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 284, 170, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Valor da Diaria: ");
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 140, 20));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Salário: ");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 400, 60, 20));

        jButtonCancelarFuncionario.setText("Cancelar");
        jButtonCancelarFuncionario.setEnabled(false);
        jButtonCancelarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarFuncionarioActionPerformed(evt);
            }
        });
        jPanel9.add(jButtonCancelarFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 520, 173, 47));

        jButtonNovo.setText("Novo Funcionário");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });
        jPanel9.add(jButtonNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 173, 47));

        jButtonSalvarFuncionario.setText("Salvar");
        jButtonSalvarFuncionario.setEnabled(false);
        jButtonSalvarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarFuncionarioActionPerformed(evt);
            }
        });
        jPanel9.add(jButtonSalvarFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 520, 173, 47));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Periodo/Dias Uteis de Trabalho: ");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 340, 250, 20));

        jTextFielDiasUteisFuncionario.setToolTipText("");
        jTextFielDiasUteisFuncionario.setEnabled(false);
        jTextFielDiasUteisFuncionario.setName("jTextFielDiasUteisFuncionario"); // NOI18N
        jTextFielDiasUteisFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFielDiasUteisFuncionarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFielDiasUteisFuncionarioKeyTyped(evt);
            }
        });
        jPanel9.add(jTextFielDiasUteisFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 130, -1));

        jTextFieldDataNascimentoFuncionario.setEnabled(false);
        jPanel9.add(jTextFieldDataNascimentoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 120, -1));

        jFormattedTextFieldValorDiariaFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        jFormattedTextFieldValorDiariaFuncionario.setEnabled(false);
        jFormattedTextFieldValorDiariaFuncionario.setName("jFormattedTextFieldValorDiariaFuncionario"); // NOI18N
        jFormattedTextFieldValorDiariaFuncionario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldValorDiariaFuncionarioFocusGained(evt);
            }
        });
        jFormattedTextFieldValorDiariaFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldValorDiariaFuncionarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldValorDiariaFuncionarioKeyTyped(evt);
            }
        });
        jPanel9.add(jFormattedTextFieldValorDiariaFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, 230, -1));

        jLabel32.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel32.setText("Descrição da Função: ");
        jLabel32.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel9.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 280, -1, -1));

        jTextAreaFuncaoFuncionario.setColumns(20);
        jTextAreaFuncaoFuncionario.setRows(5);
        jTextAreaFuncaoFuncionario.setEnabled(false);
        jScrollPane5.setViewportView(jTextAreaFuncaoFuncionario);

        jPanel9.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 270, 240, -1));

        jLabel33.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("*");
        jPanel9.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 620, 20, 20));

        jLabel34.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("*");
        jPanel9.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 190, 30, 30));

        jLabel35.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("*");
        jPanel9.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 190, 30, 30));

        jLabel36.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("*");
        jPanel9.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 130, 30, 30));

        jLabel37.setText("Campo opcional ");
        jPanel9.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 120, -1));

        jLabel38.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("*");
        jPanel9.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 240, 30, 30));

        try {
            jTextFieldCpfFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextFieldCpfFuncionario.setEnabled(false);
        jPanel9.add(jTextFieldCpfFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 230, -1));

        jComboBoxIdTipoFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxIdTipoFuncionario.setEnabled(false);
        jPanel9.add(jComboBoxIdTipoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, -1, -1));

        try {
            jTextFieldTelefone1Funcionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextFieldTelefone1Funcionario.setEnabled(false);
        jPanel9.add(jTextFieldTelefone1Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 130, 240, -1));

        try {
            jTextFieldTelefone2Funcionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextFieldTelefone2Funcionario.setEnabled(false);
        jPanel9.add(jTextFieldTelefone2Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 190, 240, -1));

        jTextFieldSalarioFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        jTextFieldSalarioFuncionario.setEnabled(false);
        jPanel9.add(jTextFieldSalarioFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 400, 240, -1));

        jLabel28.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Funcionário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Narrow", 1, 12))); // NOI18N
        jPanel9.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1340, 410));

        jTabbedPaneFuncionario.addTab("Adicionar", jPanel9);

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldEditarNomeFuncionario.setEnabled(false);
        jTextFieldEditarNomeFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEditarNomeFuncionarioActionPerformed(evt);
            }
        });
        jPanel11.add(jTextFieldEditarNomeFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 201, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Nome: ");
        jPanel11.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Sexo: ");
        jPanel11.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 100, 20));

        jRadioButtonEditarMasculinoFuncionario.setText("Masculino");
        jRadioButtonEditarMasculinoFuncionario.setEnabled(false);
        jRadioButtonEditarMasculinoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEditarMasculinoFuncionarioActionPerformed(evt);
            }
        });
        jPanel11.add(jRadioButtonEditarMasculinoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 97, -1));

        jRadioButtonEditarFemininoFuncionario.setText("Feminino");
        jRadioButtonEditarFemininoFuncionario.setEnabled(false);
        jRadioButtonEditarFemininoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEditarFemininoFuncionarioActionPerformed(evt);
            }
        });
        jPanel11.add(jRadioButtonEditarFemininoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 102, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Idade: ");
        jPanel11.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 90, 20));

        jTextFieldEditarIdadeFuncionario.setEnabled(false);
        jTextFieldEditarIdadeFuncionario.setName("jTextFieldEditarIdadeFuncionario"); // NOI18N
        jTextFieldEditarIdadeFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEditarIdadeFuncionarioKeyTyped(evt);
            }
        });
        jPanel11.add(jTextFieldEditarIdadeFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 200, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("Data de Nascimento:");
        jPanel11.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 150, 30));

        jTextFieldEditarDataNascimentoFuncionario.setEnabled(false);
        jPanel11.add(jTextFieldEditarDataNascimentoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 120, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("CPF: ");
        jPanel11.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 60, 20));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setText("Rua: ");
        jPanel11.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 60, 20));

        jTextFieldEditarRuaFuncionario.setEnabled(false);
        jPanel11.add(jTextFieldEditarRuaFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 230, -1));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("Bairro: ");
        jPanel11.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 80, 20));

        jTextFieldEditarBairroFuncionario.setEnabled(false);
        jPanel11.add(jTextFieldEditarBairroFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 230, -1));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setText("Valor da Diaria: ");
        jPanel11.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 180, 20));

        jFormattedTextFieldEditarValorDiariaFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        jFormattedTextFieldEditarValorDiariaFuncionario.setEnabled(false);
        jFormattedTextFieldEditarValorDiariaFuncionario.setName("jFormattedTextFieldEditarValorDiariaFuncionario"); // NOI18N
        jFormattedTextFieldEditarValorDiariaFuncionario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldEditarValorDiariaFuncionarioFocusGained(evt);
            }
        });
        jFormattedTextFieldEditarValorDiariaFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldEditarValorDiariaFuncionarioActionPerformed(evt);
            }
        });
        jFormattedTextFieldEditarValorDiariaFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldEditarValorDiariaFuncionarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldEditarValorDiariaFuncionarioKeyTyped(evt);
            }
        });
        jPanel11.add(jFormattedTextFieldEditarValorDiariaFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 230, -1));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel22.setText("Periodo/Dias Uteis de Trabalho: ");
        jPanel11.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 260, 20));

        jTextFielEditarDiasUteisFuncionario.setToolTipText("");
        jTextFielEditarDiasUteisFuncionario.setEnabled(false);
        jTextFielEditarDiasUteisFuncionario.setName("jTextFielDiasUteis"); // NOI18N
        jTextFielEditarDiasUteisFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFielEditarDiasUteisFuncionarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFielEditarDiasUteisFuncionarioKeyTyped(evt);
            }
        });
        jPanel11.add(jTextFielEditarDiasUteisFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, 130, -1));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel23.setText("Telefone (1): ");
        jPanel11.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 30, 110, 20));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel24.setText("Telefone (2):");
        jPanel11.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 90, 110, 20));

        jLabel52.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel52.setText("Descrição da Função:");
        jPanel11.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(903, 180, 170, -1));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel25.setText("Função: ");
        jPanel11.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 140, 110, 20));

        jComboBoxEditarTipoFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxEditarTipoFuncionario.setEnabled(false);
        jComboBoxEditarTipoFuncionario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxEditarTipoFuncionarioItemStateChanged(evt);
            }
        });
        jComboBoxEditarTipoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEditarTipoFuncionarioActionPerformed(evt);
            }
        });
        jPanel11.add(jComboBoxEditarTipoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 140, 245, -1));

        jLabel26.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel26.setText("Salário: ");
        jPanel11.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 250, 120, 20));

        jTextFieldEditarSalarioFuncionario.setEnabled(false);
        jTextFieldEditarSalarioFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEditarSalarioFuncionarioActionPerformed(evt);
            }
        });
        jPanel11.add(jTextFieldEditarSalarioFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 250, 250, -1));

        jTableFuncionario2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableFuncionario2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableFuncionario2MouseReleased(evt);
            }
        });
        jTableFuncionario2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableFuncionario2KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTableFuncionario2);

        jPanel11.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 349, 1320, 280));

        jTextAreaEditarFuncaoFuncionario.setColumns(20);
        jTextAreaEditarFuncaoFuncionario.setRows(5);
        jTextAreaEditarFuncaoFuncionario.setEnabled(false);
        jScrollPane7.setViewportView(jTextAreaEditarFuncaoFuncionario);

        jPanel11.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 170, 250, 60));

        jTextFieldEditarIdentificadorFuncionario.setEnabled(false);
        jPanel11.add(jTextFieldEditarIdentificadorFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 80, -1));

        try {
            jTextFieldEditarCpfFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextFieldEditarCpfFuncionario.setEnabled(false);
        jPanel11.add(jTextFieldEditarCpfFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 230, -1));

        try {
            jTextFieldEditarTelefone1Funcionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextFieldEditarTelefone1Funcionario.setEnabled(false);
        jPanel11.add(jTextFieldEditarTelefone1Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 30, 240, -1));

        try {
            jTextFieldEditarTelefone2Funcionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextFieldEditarTelefone2Funcionario.setEnabled(false);
        jPanel11.add(jTextFieldEditarTelefone2Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 90, 240, -1));

        jLabel55.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel55.setText("Identificador: ");
        jPanel11.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel27.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Funcionário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Narrow", 1, 12))); // NOI18N
        jPanel11.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1340, 270));

        jButtonEditarEditarFuncionario.setText("Editar");
        jButtonEditarEditarFuncionario.setEnabled(false);
        jButtonEditarEditarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarEditarFuncionarioActionPerformed(evt);
            }
        });
        jPanel11.add(jButtonEditarEditarFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 173, 47));

        jButtonEditarCancelarFuncionario.setText("Cancelar");
        jButtonEditarCancelarFuncionario.setEnabled(false);
        jButtonEditarCancelarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarCancelarFuncionarioActionPerformed(evt);
            }
        });
        jPanel11.add(jButtonEditarCancelarFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 290, 173, 47));

        jComboBoxIdEditarTipoFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxIdEditarTipoFuncionario.setEnabled(false);
        jPanel11.add(jComboBoxIdEditarTipoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 130, -1));

        jComboBoxDescricaoEditarTipoFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxDescricaoEditarTipoFuncionario.setEnabled(false);
        jPanel11.add(jComboBoxDescricaoEditarTipoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, 80, -1));

        jButtonEditarSalvarFuncionario.setText("Salvar");
        jButtonEditarSalvarFuncionario.setEnabled(false);
        jButtonEditarSalvarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarSalvarFuncionarioActionPerformed(evt);
            }
        });
        jPanel11.add(jButtonEditarSalvarFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 173, 47));

        jButtonEditarExcluirFuncionario.setText("Exluir");
        jButtonEditarExcluirFuncionario.setEnabled(false);
        jButtonEditarExcluirFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarExcluirFuncionarioActionPerformed(evt);
            }
        });
        jPanel11.add(jButtonEditarExcluirFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 290, 173, 43));

        jTabbedPaneFuncionario.addTab("Editar/Excluir", jPanel11);

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableFuncionarioMouseReleased(evt);
            }
        });
        jTableFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableFuncionarioKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFuncionario);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 1271, 336));

        jLabel39.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel39.setText("Nome: ");
        jPanel10.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 110, 26));

        jLabelVisualizarNomeFuncionario.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jPanel10.add(jLabelVisualizarNomeFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 60, 350, 26));

        jLabel40.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel40.setText("Sexo: ");
        jPanel10.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 100, 22));

        jLabelVisualizarSexoFuncionario.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jPanel10.add(jLabelVisualizarSexoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 90, 230, 22));

        jLabel41.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel41.setText("Idade: ");
        jPanel10.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 100, 30));

        jLabelVisualizarIdadeFuncionario.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jPanel10.add(jLabelVisualizarIdadeFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 240, 30));

        jLabel42.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel42.setText("Data de Nascimento: ");
        jPanel10.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 170, -1));

        jLabelVisualizarDataNascimentoFuncionario.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jPanel10.add(jLabelVisualizarDataNascimentoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 154, 170, 30));

        jLabel43.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel43.setText("CPF: ");
        jPanel10.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 130, -1));

        jLabelVisualizarCpfFuncionario.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jPanel10.add(jLabelVisualizarCpfFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 150, 20));

        jLabel44.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel44.setText("Rua: ");
        jPanel10.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 130, -1));

        jLabelVisualizarRuaFuncionario.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jPanel10.add(jLabelVisualizarRuaFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 300, 20));

        jLabel45.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel45.setText("Bairro: ");
        jPanel10.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 140, -1));

        jLabelVisualizarBairroFuncionario.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jPanel10.add(jLabelVisualizarBairroFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 290, 20));

        jLabel46.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel46.setText("Valor da Diaria: ");
        jPanel10.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 180, -1));

        jLabelVisualizarValorDiariaFuncionario.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jPanel10.add(jLabelVisualizarValorDiariaFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 260, 20));

        jLabel47.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel47.setText("Periodo/Dias Uteis de Trabalho: ");
        jPanel10.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 260, -1));

        jLabelVisualizarPeriodoDiasUteisFuncionario.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jPanel10.add(jLabelVisualizarPeriodoDiasUteisFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, 130, 20));

        jLabel48.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel48.setText("Telefone (1): ");
        jPanel10.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 40, 140, -1));

        jLabelVisualizarTelefone1Funcionario.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jPanel10.add(jLabelVisualizarTelefone1Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 40, 160, 20));

        jLabel49.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel49.setText("Telefone (2): ");
        jPanel10.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, 140, -1));

        jLabelVisualizarTelefone2Funcionario.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jPanel10.add(jLabelVisualizarTelefone2Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 70, 160, 20));

        jLabel50.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel50.setText("Função: ");
        jPanel10.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 110, 120, -1));

        jLabelVisualizarFuncaoFuncionario.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jPanel10.add(jLabelVisualizarFuncaoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 110, 350, 20));

        jLabel51.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel51.setText("Descrição da Função: ");
        jPanel10.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 140, 180, -1));

        jLabel53.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel53.setText("Salário: ");
        jPanel10.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 130, -1));

        jLabelVisualizarSalarioFuncionario.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jPanel10.add(jLabelVisualizarSalarioFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 260, 20));

        jLabel54.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel54.setText("Identificador: ");
        jPanel10.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 37, 110, 20));

        jLabelVisualizarIdentificadorFuncionario.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jPanel10.add(jLabelVisualizarIdentificadorFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 34, 200, 30));

        jLabelVisualizarDescricaoFuncionario.setColumns(20);
        jLabelVisualizarDescricaoFuncionario.setRows(5);
        jLabelVisualizarDescricaoFuncionario.setEnabled(false);
        jScrollPane6.setViewportView(jLabelVisualizarDescricaoFuncionario);

        jPanel10.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 140, 260, -1));

        jTabbedPaneFuncionario.addTab("Visualizar", jPanel10);

        jTabbedPane1.addTab("Funcionários", jTabbedPaneFuncionario);
        jTabbedPane1.addTab("Gerar Relatórios", jTabbedPane4);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setText("Identificador: ");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 72, 120, 30));

        jLabel30.setText("Nome da Função: ");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 140, 30));

        jLabel31.setText("Descrição da Função: ");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 180, 30));

        jTextFieldIdTipo.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jTextFieldIdTipo.setEnabled(false);
        jPanel1.add(jTextFieldIdTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 240, 30));

        jTextFieldNomeDoTipo.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jTextFieldNomeDoTipo.setEnabled(false);
        jPanel1.add(jTextFieldNomeDoTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 240, 30));

        jTextAreaDescricaoDoTipo.setColumns(20);
        jTextAreaDescricaoDoTipo.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jTextAreaDescricaoDoTipo.setRows(5);
        jTextAreaDescricaoDoTipo.setEnabled(false);
        jScrollPane3.setViewportView(jTextAreaDescricaoDoTipo);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 240, 100));

        jTableTipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTipoMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableTipoMouseReleased(evt);
            }
        });
        jTableTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableTipoKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jTableTipo);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 840, 250));

        jButtonSalvarTipo.setText("Salvar");
        jButtonSalvarTipo.setEnabled(false);
        jButtonSalvarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarTipoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSalvarTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 173, 47));

        jButtonNovoTipo.setText("Nova Função");
        jButtonNovoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoTipoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonNovoTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 173, 47));

        jButtonEditarTipo.setText("Editar");
        jButtonEditarTipo.setEnabled(false);
        jButtonEditarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarTipoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEditarTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, 173, 47));

        jButtonExcluirTipo.setText("Excluir");
        jButtonExcluirTipo.setEnabled(false);
        jButtonExcluirTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirTipoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonExcluirTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 390, 173, 47));

        jButtonCancelarTipo.setText("Cancelar");
        jButtonCancelarTipo.setEnabled(false);
        jButtonCancelarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarTipoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancelarTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 390, 173, 47));

        jTabbedPane5.addTab("Opções", jPanel1);

        jTabbedPane1.addTab("Função/Funcionário", jTabbedPane5);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    // Obtem o valor do salário levando em conta o valor da diaria e os respectivos dias de trabalho.
    private void obterSalario(){
        double diaria = 0.0;
        int dias = 0;
        
        if(!"".equals(jFormattedTextFieldValorDiariaFuncionario.getText().trim().replace("R$", "")) &&
           !"".equals(jTextFielDiasUteisFuncionario.getText().trim())){
           diaria = Double.parseDouble(jFormattedTextFieldValorDiariaFuncionario.getText().trim().replace(" ", "").replace(".", "").replace("R$", "").replace(",", "."));
           dias = Integer.parseInt(jTextFielDiasUteisFuncionario.getText().trim());                
           jTextFieldSalarioFuncionario.setText(currencyFormatter.format(diaria*dias));            
       }else{
            if("".equals(jFormattedTextFieldValorDiariaFuncionario.getText().trim().replace("R$", "")) ||
               "".equals(jTextFielDiasUteisFuncionario.getText().trim())){
            }
                jTextFieldSalarioFuncionario.setText("");
        }                    
    }
    
    private void obterSalarioEditar(){
        double diaria = 0.0;
        int dias = 0;
        
        if(!"".equals(jFormattedTextFieldEditarValorDiariaFuncionario.getText().trim().replace("R$", "")) &&
           !"".equals(jTextFielEditarDiasUteisFuncionario.getText().trim())){
           diaria = Double.parseDouble(jFormattedTextFieldEditarValorDiariaFuncionario.getText().trim().replace(" ", "").replace(".", "").replace("R$", "").replace(",", "."));
           dias = Integer.parseInt(jTextFielEditarDiasUteisFuncionario.getText().trim());                
           jTextFieldEditarSalarioFuncionario.setText(currencyFormatter.format(diaria*dias));            
       }else{
            if("".equals(jFormattedTextFieldEditarValorDiariaFuncionario.getText().trim().replace("R$", "")) ||
               "".equals(jTextFielEditarDiasUteisFuncionario.getText().trim())){
            }
                jTextFieldEditarSalarioFuncionario.setText("");
        }                    
    }
        
    private void proibirLetras(KeyEvent evt, String nome){
        int k = evt.getKeyChar();        
        if(jTextFielDiasUteisFuncionario.getName().equals(nome) || jTextFieldIdadeFuncionario.getName().equals(nome)){
            if((!(k > 47 && k < 58))) {            
                evt.setKeyChar((char)KeyEvent.VK_CLEAR);             
            } 
        }else{                        
            if(k == 44 | k == 46){
            }else{
                if((!(k > 47 && k < 58))) {            
                    evt.setKeyChar((char)KeyEvent.VK_CLEAR);             
                } 
            }        
        }        
    } 
    
    //
    private void proibirLetrasEditar(KeyEvent evt, String nome){
        int k = evt.getKeyChar();        
        if(jTextFielEditarDiasUteisFuncionario.getName().equals(nome) || jTextFieldEditarIdadeFuncionario.getName().equals(nome)){
            if((!(k > 47 && k < 58))) {            
                evt.setKeyChar((char)KeyEvent.VK_CLEAR);             
            } 
        }else{                        
            if(k == 44 | k == 46){
            }else{
                if((!(k > 47 && k < 58))) {            
                    evt.setKeyChar((char)KeyEvent.VK_CLEAR);             
                } 
            }        
        }        
    } 
    
    
    private void obterTipoDaTabela(){
        if(jTableTipo.getSelectedRow() != -1){
            jTextFieldIdTipo.setText(String.valueOf(jTableTipo.getValueAt(jTableTipo.getSelectedRow(), 0)));
            jTextFieldNomeDoTipo.setText(String.valueOf(jTableTipo.getValueAt(jTableTipo.getSelectedRow(), 1)));
            jTextAreaDescricaoDoTipo.setText(String.valueOf(jTableTipo.getValueAt(jTableTipo.getSelectedRow(), 2)));
            
            habilitarBotoesTipo(0, 0, 1, 1, 1);
            
            habilitarCamposTipo(0, 0);
        }
    }
    
    private void obterFuncionarioTabela(){
        if(jTableFuncionario.getSelectedRow() != -1){
            jLabelVisualizarIdentificadorFuncionario.setText(String.valueOf(jTableFuncionario.getValueAt(jTableFuncionario.getSelectedRow(), 0)));
            jLabelVisualizarNomeFuncionario.setText(String.valueOf(jTableFuncionario.getValueAt(jTableFuncionario.getSelectedRow(), 1)));
            jLabelVisualizarSexoFuncionario.setText(String.valueOf(jTableFuncionario.getValueAt(jTableFuncionario.getSelectedRow(), 2)));
            jLabelVisualizarIdadeFuncionario.setText(String.valueOf(jTableFuncionario.getValueAt(jTableFuncionario.getSelectedRow(), 3)));
            jLabelVisualizarDataNascimentoFuncionario.setText(String.valueOf(jTableFuncionario.getValueAt(jTableFuncionario.getSelectedRow(), 4)));
            jLabelVisualizarFuncaoFuncionario.setText(String.valueOf(jTableFuncionario.getValueAt(jTableFuncionario.getSelectedRow(), 5)));
            jLabelVisualizarDescricaoFuncionario.setText(String.valueOf(jTableFuncionario.getValueAt(jTableFuncionario.getSelectedRow(), 6)));
            jLabelVisualizarRuaFuncionario.setText(String.valueOf(jTableFuncionario.getValueAt(jTableFuncionario.getSelectedRow(), 7)));
            jLabelVisualizarBairroFuncionario.setText(String.valueOf(jTableFuncionario.getValueAt(jTableFuncionario.getSelectedRow(), 8)));
            jLabelVisualizarCpfFuncionario.setText(String.valueOf(jTableFuncionario.getValueAt(jTableFuncionario.getSelectedRow(), 9)));
            jLabelVisualizarTelefone1Funcionario.setText(String.valueOf(jTableFuncionario.getValueAt(jTableFuncionario.getSelectedRow(), 10)));
            jLabelVisualizarTelefone2Funcionario.setText(String.valueOf(jTableFuncionario.getValueAt(jTableFuncionario.getSelectedRow(), 11)));
            jLabelVisualizarPeriodoDiasUteisFuncionario.setText(String.valueOf(jTableFuncionario.getValueAt(jTableFuncionario.getSelectedRow(), 12)));
            jLabelVisualizarValorDiariaFuncionario.setText(String.valueOf(jTableFuncionario.getValueAt(jTableFuncionario.getSelectedRow(), 13)));
            jLabelVisualizarSalarioFuncionario.setText(String.valueOf(jTableFuncionario.getValueAt(jTableFuncionario.getSelectedRow(), 14)));                            
        }
    }
    
    private void obterFuncionarioTabela2(){
        if(jTableFuncionario2.getSelectedRow() != -1){
            jTextFieldEditarIdentificadorFuncionario.setText(String.valueOf(jTableFuncionario2.getValueAt(jTableFuncionario2.getSelectedRow(), 0)));
            jTextFieldEditarNomeFuncionario.setText(String.valueOf(jTableFuncionario2.getValueAt(jTableFuncionario2.getSelectedRow(), 1)));
             
            // É menino ou menina?
            if(String.valueOf(jTableFuncionario2.getValueAt(jTableFuncionario2.getSelectedRow(), 2)).equals("Feminino")){
                jRadioButtonEditarFemininoFuncionario.setSelected(t);     
                jRadioButtonEditarMasculinoFuncionario.setSelected(f);
            }else{
                if(String.valueOf(jTableFuncionario2.getValueAt(jTableFuncionario2.getSelectedRow(), 2)).equals("Masculino")){                
                    jRadioButtonEditarMasculinoFuncionario.setSelected(t);
                    jRadioButtonEditarFemininoFuncionario.setSelected(f);
                }
            }            
            
            jTextFieldEditarIdadeFuncionario.setText(String.valueOf(jTableFuncionario2.getValueAt(jTableFuncionario2.getSelectedRow(), 3)));
            try {
                jTextFieldEditarDataNascimentoFuncionario.setDate(dateFormat.parse(String.valueOf(jTableFuncionario2.getValueAt(jTableFuncionario2.getSelectedRow(), 4))));
            } catch (ParseException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Trata o jcombobox tipo de função da aba editar
            for(int i = 0; i < jComboBoxEditarTipoFuncionario.getItemCount()-1; i++){
                if(jComboBoxEditarTipoFuncionario.getItemAt(i).trim().equals(String.valueOf(jTableFuncionario2.getValueAt(jTableFuncionario2.getSelectedRow(), 5)))){
                    jComboBoxEditarTipoFuncionario.setSelectedIndex(i);
                }
            }
            
            jTextFieldEditarRuaFuncionario.setText(String.valueOf(jTableFuncionario2.getValueAt(jTableFuncionario2.getSelectedRow(), 7)));
            jTextFieldEditarBairroFuncionario.setText(String.valueOf(jTableFuncionario2.getValueAt(jTableFuncionario2.getSelectedRow(), 8)));
            jTextFieldEditarCpfFuncionario.setText(String.valueOf(jTableFuncionario2.getValueAt(jTableFuncionario2.getSelectedRow(), 9)));
            jTextFieldEditarTelefone1Funcionario.setText(String.valueOf(jTableFuncionario2.getValueAt(jTableFuncionario2.getSelectedRow(), 10)));
            jTextFieldEditarTelefone2Funcionario.setText(String.valueOf(jTableFuncionario2.getValueAt(jTableFuncionario2.getSelectedRow(), 11)));
            jTextFielEditarDiasUteisFuncionario.setText(String.valueOf(jTableFuncionario2.getValueAt(jTableFuncionario2.getSelectedRow(), 12)));
            jFormattedTextFieldEditarValorDiariaFuncionario.setText(String.valueOf(jTableFuncionario2.getValueAt(jTableFuncionario2.getSelectedRow(), 13)));
            jTextFieldEditarSalarioFuncionario.setText(String.valueOf(jTableFuncionario2.getValueAt(jTableFuncionario2.getSelectedRow(), 14)));                            
            
            habilitarBotoesEditar(1, 0, 0, 1);
            habilitarCamposEditar(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        }
    }
    
    
    private void jButtonNovoTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoTipoActionPerformed
        flagTipo = 1;
        // habilitarCamposTipo(int nome, int descricao);
        habilitarCamposTipo(1, 1);
        
        // habilitarBotoesTipo(int novo, int salvar, int cancelar, int editar, int excluir)
        habilitarBotoesTipo(0, 1, 1, 0, 0);
    }//GEN-LAST:event_jButtonNovoTipoActionPerformed

    private void jButtonCancelarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarTipoActionPerformed
        // Limpa todos os campos do formulário de tipos
        limparCamposTipo();
        
        // habilitarCamposTipo(int nome, int descricao);        
        habilitarCamposTipo(0, 0);
        
        // habilitarBotoesTipo(int novo, int salvar, int cancelar, int editar, int excluir)
        habilitarBotoesTipo(1, 0, 0, 0, 0);                
    }//GEN-LAST:event_jButtonCancelarTipoActionPerformed

    
    private void jButtonSalvarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarTipoActionPerformed
        if( flagTipo == 1){
            if(!"".equals(jTextFieldNomeDoTipo.getText().trim()) && !"".equals(jTextAreaDescricaoDoTipo.getText().trim())){
                tipoPojo.setNome(jTextFieldNomeDoTipo.getText().trim());
                tipoPojo.setDescricao(jTextAreaDescricaoDoTipo.getText().trim());
                                
                daoTipo.salvar(tipoPojo);
                
                // Limpa todos os campos do formulário de tipos
                limparCamposTipo();
                
                // habilitarCamposTipo(int nome, int descricao);        
                habilitarCamposTipo(0, 0);
                
                // habilitarBotoesTipo(int novo, int salvar, int cancelar, int editar, int excluir)
                habilitarBotoesTipo(1, 0, 0, 0, 0);   
                
                // criar um método para atualizar todos os campos dos outros paineis que pucham informações do banco de dados
                // Atualiza as funções do funcionario
                daoFuncionario.buscarTipos(jComboBoxTipoFuncionario, jComboBox1, jComboBoxIdTipoFuncionario);
                daoTipo.preencherTabela(jTableTipo);                                
                
            }else{
                if("".equals(jTextFieldNomeDoTipo.getText().trim()) && !"".equals(jTextAreaDescricaoDoTipo.getText().trim())){
                    JOptionPane.showMessageDialog(null, "Preencha o campo Nome!");
                    jTextFieldNomeDoTipo.requestFocus();
                }
                
                if(!"".equals(jTextFieldNomeDoTipo.getText().trim()) && "".equals(jTextAreaDescricaoDoTipo.getText().trim())){
                    JOptionPane.showMessageDialog(null, "Preencha o campo Descrição!");
                    jTextAreaDescricaoDoTipo.requestFocus();
                }
                
                if("".equals(jTextFieldNomeDoTipo.getText().trim()) && "".equals(jTextAreaDescricaoDoTipo.getText().trim())){
                    JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos!");
                    jTextFieldNomeDoTipo.requestFocus();
                }
            }                            
        }
        
        else{
            if(!"".equals(jTextFieldNomeDoTipo.getText().trim()) && !"".equals(jTextAreaDescricaoDoTipo.getText().trim())){
                tipoPojo.setNome(jTextFieldNomeDoTipo.getText().trim());
                tipoPojo.setDescricao(jTextAreaDescricaoDoTipo.getText().trim());
                tipoPojo.setId_tipo(Integer.parseInt(jTextFieldIdTipo.getText().trim()));
                daoTipo.editar(tipoPojo);
                
                // Limpa todos os campos do formulário de tipos
                limparCamposTipo();
                
                // habilitarCamposTipo(int nome, int descricao);        
                habilitarCamposTipo(0, 0);
                
                // habilitarBotoesTipo(int novo, int salvar, int cancelar, int editar, int excluir)
                habilitarBotoesTipo(1, 0, 0, 0, 0);   
                
                // criar um método para atualizar todos os campos dos outros paineis que pucham informações do banco de dados
                // Atualiza as funções do funcionario
                daoFuncionario.buscarTipos(jComboBoxTipoFuncionario, jComboBox1, jComboBoxIdTipoFuncionario);
                daoTipo.preencherTabela(jTableTipo);
                                
            }else{
                if("".equals(jTextFieldNomeDoTipo.getText().trim()) && !"".equals(jTextAreaDescricaoDoTipo.getText().trim())){
                    JOptionPane.showMessageDialog(null, "Preencha o campo Nome!");
                    jTextFieldNomeDoTipo.requestFocus();
                }
                
                if(!"".equals(jTextFieldNomeDoTipo.getText().trim()) && "".equals(jTextAreaDescricaoDoTipo.getText().trim())){
                    JOptionPane.showMessageDialog(null, "Preencha o campo Descrição!");
                    jTextAreaDescricaoDoTipo.requestFocus();
                }
                
                if("".equals(jTextFieldNomeDoTipo.getText().trim()) && "".equals(jTextAreaDescricaoDoTipo.getText().trim())){
                    JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos!");
                    jTextFieldNomeDoTipo.requestFocus();
                }
            }                                        
        }
    }//GEN-LAST:event_jButtonSalvarTipoActionPerformed

    private void jButtonEditarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarTipoActionPerformed
        flagTipo = 2;        
        // habilitarBotoesTipo(int novo, int salvar, int cancelar, int editar, int excluir)
        habilitarBotoesTipo(0, 1, 1, 0, 0);
        habilitarCamposTipo(1, 1);
        
    }//GEN-LAST:event_jButtonEditarTipoActionPerformed

    private void jTableTipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTipoMouseClicked
        obterTipoDaTabela();
    }//GEN-LAST:event_jTableTipoMouseClicked

    private void jTableTipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableTipoKeyReleased
        obterTipoDaTabela();
    }//GEN-LAST:event_jTableTipoKeyReleased

    private void jButtonExcluirTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirTipoActionPerformed
        if(jTableTipo.getSelectedRow() != -1){
            tipoPojo.setId_tipo(Integer.parseInt(jTextFieldIdTipo.getText().trim()));
            tipoPojo.setNome(jTextFieldNomeDoTipo.getText().trim());                        
            
            daoTipo.excluir(tipoPojo);
            
            daoFuncionario.buscarTipos(jComboBoxTipoFuncionario, jComboBox1, jComboBoxIdTipoFuncionario);
            daoTipo.preencherTabela(jTableTipo);
            
            // Limpa todos os campos do formulário de tipos
            limparCamposTipo();
            
            // habilitarBotoesTipo(int novo, int salvar, int cancelar, int editar, int excluir)
            habilitarBotoesTipo(1, 0, 0, 0, 0);               
        }
    }//GEN-LAST:event_jButtonExcluirTipoActionPerformed

    private void jTableTipoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTipoMouseReleased
        obterTipoDaTabela();
    }//GEN-LAST:event_jTableTipoMouseReleased

    private void jButtonEditarSalvarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarSalvarFuncionarioActionPerformed
        funcionarioPojo.setId_funcionario(Integer.parseInt(jTextFieldEditarIdentificadorFuncionario.getText().trim()));

        if(jComboBoxEditarTipoFuncionario.getSelectedIndex() != -1){
            if(jComboBoxIdEditarTipoFuncionario.getItemAt((jComboBoxEditarTipoFuncionario.getSelectedIndex())) != null ){
                // Criar outro jcombobox para o id do tipo (ok)
                funcionarioPojo.setId_tipo(Integer.parseInt(jComboBoxIdEditarTipoFuncionario.getItemAt( (jComboBoxEditarTipoFuncionario.getSelectedIndex()) )));
            }
        }

        funcionarioPojo.setIdade(Integer.parseInt(jTextFieldEditarIdadeFuncionario.getText().trim()));

        if(jRadioButtonEditarFemininoFuncionario.isSelected()){
            funcionarioPojo.setSexo('F');
        }else{
            if(jRadioButtonEditarMasculinoFuncionario.isSelected()){
                funcionarioPojo.setSexo('M');
            }
        }

        funcionarioPojo.setData_nascimento(jTextFieldEditarDataNascimentoFuncionario.getDate());
        funcionarioPojo.setTelefone_1(jTextFieldEditarTelefone1Funcionario.getText());
        funcionarioPojo.setTelefone_2(jTextFieldEditarTelefone2Funcionario.getText());
        funcionarioPojo.setValor_diaria(Double.parseDouble(jFormattedTextFieldEditarValorDiariaFuncionario.getText().trim().replace(".", "").replace("R$", "").replace(" ", "").replace(",", ".")));
        funcionarioPojo.setSalario(Double.parseDouble(jTextFieldEditarSalarioFuncionario.getText().trim().replace(".", "").replace("R$", "").replace(" ", "").replace(",", ".")));
        funcionarioPojo.setNome(jTextFieldEditarNomeFuncionario.getText().trim());
        funcionarioPojo.setRua(jTextFieldEditarRuaFuncionario.getText().trim());
        funcionarioPojo.setBairro(jTextFieldEditarBairroFuncionario.getText().trim());
        funcionarioPojo.setQtd_dias_de_trabalho(Integer.parseInt(jTextFielEditarDiasUteisFuncionario.getText().trim()));
        funcionarioPojo.setCpf(jTextFieldEditarCpfFuncionario.getText().trim());

        daoFuncionario.editar(funcionarioPojo);

        limparCamposEditar();
        habilitarCamposEditar(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        habilitarBotoesEditar(0, 0, 0, 0);

        daoFuncionario.preencherTabela(jTableFuncionario);
        daoFuncionario.preencherTabela(jTableFuncionario2);
    }//GEN-LAST:event_jButtonEditarSalvarFuncionarioActionPerformed

    private void jButtonEditarCancelarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarCancelarFuncionarioActionPerformed
        limparCamposEditar();
        habilitarCamposEditar(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        habilitarBotoesEditar(0, 0, 0, 0);

    }//GEN-LAST:event_jButtonEditarCancelarFuncionarioActionPerformed

    private void jButtonEditarEditarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarEditarFuncionarioActionPerformed
        habilitarCamposEditar(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1);
        habilitarBotoesEditar(0, 1, 1, 0);
    }//GEN-LAST:event_jButtonEditarEditarFuncionarioActionPerformed

    private void jTableFuncionario2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableFuncionario2KeyReleased
        obterFuncionarioTabela2();
    }//GEN-LAST:event_jTableFuncionario2KeyReleased

    private void jTableFuncionario2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFuncionario2MouseReleased
        obterFuncionarioTabela2();
    }//GEN-LAST:event_jTableFuncionario2MouseReleased

    private void jTextFieldEditarSalarioFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEditarSalarioFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEditarSalarioFuncionarioActionPerformed

    private void jComboBoxEditarTipoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEditarTipoFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEditarTipoFuncionarioActionPerformed

    private void jComboBoxEditarTipoFuncionarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEditarTipoFuncionarioItemStateChanged
        jTextAreaEditarFuncaoFuncionario.setText(jComboBoxDescricaoEditarTipoFuncionario.getItemAt(jComboBoxEditarTipoFuncionario.getSelectedIndex()));
    }//GEN-LAST:event_jComboBoxEditarTipoFuncionarioItemStateChanged

    private void jTextFielEditarDiasUteisFuncionarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFielEditarDiasUteisFuncionarioKeyTyped
        proibirLetrasEditar(evt, jTextFielEditarDiasUteisFuncionario.getName());
    }//GEN-LAST:event_jTextFielEditarDiasUteisFuncionarioKeyTyped

    private void jTextFielEditarDiasUteisFuncionarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFielEditarDiasUteisFuncionarioKeyReleased
        obterSalarioEditar();
    }//GEN-LAST:event_jTextFielEditarDiasUteisFuncionarioKeyReleased

    private void jFormattedTextFieldEditarValorDiariaFuncionarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldEditarValorDiariaFuncionarioKeyTyped
        proibirLetrasEditar(evt, jFormattedTextFieldEditarValorDiariaFuncionario.getName());
    }//GEN-LAST:event_jFormattedTextFieldEditarValorDiariaFuncionarioKeyTyped

    private void jFormattedTextFieldEditarValorDiariaFuncionarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldEditarValorDiariaFuncionarioKeyReleased
        obterSalarioEditar();
    }//GEN-LAST:event_jFormattedTextFieldEditarValorDiariaFuncionarioKeyReleased

    private void jFormattedTextFieldEditarValorDiariaFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldEditarValorDiariaFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldEditarValorDiariaFuncionarioActionPerformed

    private void jFormattedTextFieldEditarValorDiariaFuncionarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldEditarValorDiariaFuncionarioFocusGained
        if(!jFormattedTextFieldEditarValorDiariaFuncionario.getText().contains("R$")){
            jFormattedTextFieldEditarValorDiariaFuncionario.setText("R$ " + jFormattedTextFieldEditarValorDiariaFuncionario.getText().trim());
        }
    }//GEN-LAST:event_jFormattedTextFieldEditarValorDiariaFuncionarioFocusGained

    private void jTextFieldEditarIdadeFuncionarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEditarIdadeFuncionarioKeyTyped
        proibirLetrasEditar(evt, jTextFieldEditarIdadeFuncionario.getName());
    }//GEN-LAST:event_jTextFieldEditarIdadeFuncionarioKeyTyped

    private void jRadioButtonEditarFemininoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEditarFemininoFuncionarioActionPerformed
        if(jRadioButtonEditarFemininoFuncionario.isSelected()){
            jRadioButtonEditarMasculinoFuncionario.setSelected(f);
        }
    }//GEN-LAST:event_jRadioButtonEditarFemininoFuncionarioActionPerformed

    private void jRadioButtonEditarMasculinoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEditarMasculinoFuncionarioActionPerformed
        if(jRadioButtonEditarMasculinoFuncionario.isSelected()){
            jRadioButtonEditarFemininoFuncionario.setSelected(f);
        }
    }//GEN-LAST:event_jRadioButtonEditarMasculinoFuncionarioActionPerformed

    private void jTextFieldEditarNomeFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEditarNomeFuncionarioActionPerformed

    }//GEN-LAST:event_jTextFieldEditarNomeFuncionarioActionPerformed

    private void jTableFuncionarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableFuncionarioKeyReleased
        obterFuncionarioTabela();
    }//GEN-LAST:event_jTableFuncionarioKeyReleased

    private void jTableFuncionarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFuncionarioMouseReleased
        obterFuncionarioTabela();
    }//GEN-LAST:event_jTableFuncionarioMouseReleased

    private void jFormattedTextFieldValorDiariaFuncionarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldValorDiariaFuncionarioKeyTyped
        proibirLetras(evt, jFormattedTextFieldValorDiariaFuncionario.getName());
    }//GEN-LAST:event_jFormattedTextFieldValorDiariaFuncionarioKeyTyped

    private void jFormattedTextFieldValorDiariaFuncionarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldValorDiariaFuncionarioKeyReleased
        obterSalario();
    }//GEN-LAST:event_jFormattedTextFieldValorDiariaFuncionarioKeyReleased

    private void jFormattedTextFieldValorDiariaFuncionarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldValorDiariaFuncionarioFocusGained
        if(!jFormattedTextFieldValorDiariaFuncionario.getText().contains("R$")){
            jFormattedTextFieldValorDiariaFuncionario.setText("R$ " + jFormattedTextFieldValorDiariaFuncionario.getText().trim());
        }
    }//GEN-LAST:event_jFormattedTextFieldValorDiariaFuncionarioFocusGained

    private void jTextFielDiasUteisFuncionarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFielDiasUteisFuncionarioKeyTyped
        proibirLetras(evt, jTextFielDiasUteisFuncionario.getName());
    }//GEN-LAST:event_jTextFielDiasUteisFuncionarioKeyTyped

    private void jTextFielDiasUteisFuncionarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFielDiasUteisFuncionarioKeyReleased
        obterSalario();
    }//GEN-LAST:event_jTextFielDiasUteisFuncionarioKeyReleased

    private void jButtonSalvarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarFuncionarioActionPerformed

        if( !"".equals(jTextFieldNomeFuncionario.getText().trim()) &&
            !"".equals(jTextFieldIdadeFuncionario.getText().trim()) &&
            jTextFieldDataNascimentoFuncionario.getDate() != null &&
            !"".equals(jTextFieldCpfFuncionario.getText().trim()) &&
            !"".equals(jFormattedTextFieldValorDiariaFuncionario.getText().trim()) &&
            !"".equals(jTextFielDiasUteisFuncionario.getText().trim()) ){

            // insere na funcionarioPojo e salva no banco de dados
            funcionarioPojo.setNome(jTextFieldNomeFuncionario.getText().trim());
            funcionarioPojo.setIdade(Integer.parseInt(jTextFieldIdadeFuncionario.getText().trim()));
            funcionarioPojo.setData_nascimento(jTextFieldDataNascimentoFuncionario.getDate());
            funcionarioPojo.setCpf(jTextFieldCpfFuncionario.getText().trim());
            funcionarioPojo.setValor_diaria(Double.parseDouble(jFormattedTextFieldValorDiariaFuncionario.getText().trim().replace(".", "").replace("R$", "").replace(" ", "").replace(",", ".")));
            funcionarioPojo.setQtd_dias_de_trabalho(Integer.parseInt(jTextFielDiasUteisFuncionario.getText().trim()));
            funcionarioPojo.setRua(jTextFieldRuaFuncionario.getText().trim());
            funcionarioPojo.setBairro(jTextFieldBairroFuncionario.getText().trim());
            funcionarioPojo.setTelefone_1(jTextFieldTelefone1Funcionario.getText().trim());
            funcionarioPojo.setTelefone_2(jTextFieldTelefone2Funcionario.getText().trim());

            if(jComboBoxTipoFuncionario.getSelectedIndex() != -1){
                if(jComboBoxIdTipoFuncionario.getItemAt((jComboBoxTipoFuncionario.getSelectedIndex())) != null ){
                    // Criar outro jcombobox para o id do tipo (ok)
                    funcionarioPojo.setId_tipo(Integer.parseInt(jComboBoxIdTipoFuncionario.getItemAt( (jComboBoxTipoFuncionario.getSelectedIndex()) )));
                }
            }

            if(jRadioButtonFemininoFuncionario.isSelected()){
                funcionarioPojo.setSexo('F');
            }else{
                if(jRadioButtonMasculinoFuncionario.isSelected()){
                    funcionarioPojo.setSexo('M');
                }
            }

            funcionarioPojo.setSalario(Double.parseDouble(jTextFieldSalarioFuncionario.getText().trim().replace(".", "").replace("R$", "").replace(" ", "").replace(",", ".")));
            System.out.println(funcionarioPojo.getSalario());

            daoFuncionario.salvar(funcionarioPojo);
            // Atualiza a tabela funcionário
            daoFuncionario.preencherTabela(jTableFuncionario);
            daoFuncionario.preencherTabela(jTableFuncionario2);

            // Limpa os campos do funcionário
            limparCampos();
            // Habilita o campo salvar
            habilitarBotoes(1, 0, 0);

            habilitarCampos(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        }else{
            JOptionPane.showMessageDialog(null, "Preencha os campos!");
            jTextFieldNomeFuncionario.requestFocus();
        }

        // Se somente o campo nome não foi preenchido
        if( "".equals(jTextFieldNomeFuncionario.getText().trim()) &&
            !"".equals(jTextFieldIdadeFuncionario.getText().trim()) &&
            jTextFieldDataNascimentoFuncionario.getDate() != null &&
            !"".equals(jTextFieldCpfFuncionario.getText().trim()) &&
            !"".equals(jFormattedTextFieldValorDiariaFuncionario.getText().trim()) &&
            !"".equals(jTextFielDiasUteisFuncionario.getText().trim()) ){

            JOptionPane.showMessageDialog(null, "Preencha o campo Nome!");
            jTextFieldNomeFuncionario.requestFocus();
        }

        if( !"".equals(jTextFieldNomeFuncionario.getText().trim()) &&
            "".equals(jTextFieldIdadeFuncionario.getText().trim()) &&
            jTextFieldDataNascimentoFuncionario.getDate() != null &&
            !"".equals(jTextFieldCpfFuncionario.getText().trim()) &&
            !"".equals(jFormattedTextFieldValorDiariaFuncionario.getText().trim()) &&
            !"".equals(jTextFielDiasUteisFuncionario.getText().trim()) ){

            JOptionPane.showMessageDialog(null, "Preencha o campo Idade!");
            jTextFieldIdadeFuncionario.requestFocus();
        }

        if( !"".equals(jTextFieldNomeFuncionario.getText().trim()) &&
            !"".equals(jTextFieldIdadeFuncionario.getText().trim()) &&
            jTextFieldDataNascimentoFuncionario.getDate() == null &&
            !"".equals(jTextFieldCpfFuncionario.getText().trim()) &&
            !"".equals(jFormattedTextFieldValorDiariaFuncionario.getText().trim()) &&
            !"".equals(jTextFielDiasUteisFuncionario.getText().trim()) ){

            JOptionPane.showMessageDialog(null, "Preencha o campo Data de Nascimento!");
            jTextFieldDataNascimentoFuncionario.requestFocus();
        }

        if( !"".equals(jTextFieldNomeFuncionario.getText().trim()) &&
            !"".equals(jTextFieldIdadeFuncionario.getText().trim()) &&
            jTextFieldDataNascimentoFuncionario.getDate() != null &&
            "".equals(jTextFieldCpfFuncionario.getText().trim()) &&
            !"".equals(jFormattedTextFieldValorDiariaFuncionario.getText().trim()) &&
            !"".equals(jTextFielDiasUteisFuncionario.getText().trim()) ){

            JOptionPane.showMessageDialog(null, "Preencha o campo CPF!");
            jTextFieldCpfFuncionario.requestFocus();
        }

        if( !"".equals(jTextFieldNomeFuncionario.getText().trim()) &&
            !"".equals(jTextFieldIdadeFuncionario.getText().trim()) &&
            jTextFieldDataNascimentoFuncionario.getDate() != null &&
            !"".equals(jTextFieldCpfFuncionario.getText().trim()) &&
            "".equals(jFormattedTextFieldValorDiariaFuncionario.getText().trim()) &&
            !"".equals(jTextFielDiasUteisFuncionario.getText().trim()) ){

            JOptionPane.showMessageDialog(null, "Preencha o campo Valor da Diaria!");
            jFormattedTextFieldValorDiariaFuncionario.requestFocus();
        }

        if( !"".equals(jTextFieldNomeFuncionario.getText().trim()) &&
            !"".equals(jTextFieldIdadeFuncionario.getText().trim()) &&
            jTextFieldDataNascimentoFuncionario.getDate() != null &&
            !"".equals(jTextFieldCpfFuncionario.getText().trim()) &&
            "".equals(jFormattedTextFieldValorDiariaFuncionario.getText().trim()) &&
            !"".equals(jTextFielDiasUteisFuncionario.getText().trim()) ){

            JOptionPane.showMessageDialog(null, "Preencha o campo Valor da Diaria!");
            jFormattedTextFieldValorDiariaFuncionario.requestFocus();
        }

        if( !"".equals(jTextFieldNomeFuncionario.getText().trim()) &&
            !"".equals(jTextFieldIdadeFuncionario.getText().trim()) &&
            jTextFieldDataNascimentoFuncionario.getDate() != null &&
            !"".equals(jTextFieldCpfFuncionario.getText().trim()) &&
            !"".equals(jFormattedTextFieldValorDiariaFuncionario.getText().trim()) &&
            "".equals(jTextFielDiasUteisFuncionario.getText().trim()) ){

            JOptionPane.showMessageDialog(null, "Preencha o campo Dias Uteis!");
            jTextFielDiasUteisFuncionario.requestFocus();
        }
    }//GEN-LAST:event_jButtonSalvarFuncionarioActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        // nome, masculino, feminino, idade, cpf, rua, bairro, valorDiaria, telefone1, telefone2, tipo, salario, dataNascimento, diasUteis
        // total de 12 campos
        habilitarCampos(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1);
        // novo, salvar, cancelar
        // total de 3 butões
        habilitarBotoes(0, 1, 1);
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonCancelarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarFuncionarioActionPerformed
        // limpa todos os campos do funcionário
        limparCampos();
        // nome, masculino, feminino, idade, cpf, rua, bairro, valorDiaria, telefone1, telefone2, tipo, salario, dataNascimento, diasUteis
        // total de 12 campos
        habilitarCampos(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        // novo, salvar, cancelar
        // total de 3 butões
        habilitarBotoes(1, 0, 0);
    }//GEN-LAST:event_jButtonCancelarFuncionarioActionPerformed

    private void jComboBoxTipoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoFuncionarioActionPerformed

    }//GEN-LAST:event_jComboBoxTipoFuncionarioActionPerformed

    private void jComboBoxTipoFuncionarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTipoFuncionarioItemStateChanged
        jTextAreaFuncaoFuncionario.setText(jComboBox1.getItemAt(jComboBoxTipoFuncionario.getSelectedIndex()));
    }//GEN-LAST:event_jComboBoxTipoFuncionarioItemStateChanged

    private void jTextFieldIdadeFuncionarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIdadeFuncionarioKeyTyped
        proibirLetras(evt, jTextFieldIdadeFuncionario.getName());
    }//GEN-LAST:event_jTextFieldIdadeFuncionarioKeyTyped

    private void jRadioButtonFemininoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFemininoFuncionarioActionPerformed
        if(jRadioButtonMasculinoFuncionario.isSelected()){
            jRadioButtonMasculinoFuncionario.setSelected(f);
        }
    }//GEN-LAST:event_jRadioButtonFemininoFuncionarioActionPerformed

    private void jRadioButtonMasculinoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMasculinoFuncionarioActionPerformed
        if(jRadioButtonFemininoFuncionario.isSelected()){
            jRadioButtonFemininoFuncionario.setSelected(f);
        }
    }//GEN-LAST:event_jRadioButtonMasculinoFuncionarioActionPerformed

    private void jTextFieldNomeFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeFuncionarioActionPerformed

    }//GEN-LAST:event_jTextFieldNomeFuncionarioActionPerformed

    private void jButtonEditarExcluirFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarExcluirFuncionarioActionPerformed
        if(jTableFuncionario2.getSelectedRow() != -1){
            funcionarioPojo.setId_funcionario(Integer.parseInt(jTextFieldEditarIdentificadorFuncionario.getText().trim()));        
            funcionarioPojo.setNome(jTextFieldEditarNomeFuncionario.getText().trim());        
            
            daoFuncionario.excluir(funcionarioPojo);
            
            habilitarBotoesEditar(0, 0, 0, 0);
            limparCamposEditar(); 
            
            daoFuncionario.preencherTabela(jTableFuncionario);
            daoFuncionario.preencherTabela(jTableFuncionario2);
        }        
    }//GEN-LAST:event_jButtonEditarExcluirFuncionarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       jDateChooserPonto.setDate(new Date());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonPontoAdicionarNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPontoAdicionarNovoActionPerformed
        // Habilitando os botões salvar e cancelar.
        jButtonPontoAdicionarNovo.setEnabled(f);
        jButtonPontoAdicionarSalvar.setEnabled(t);
        jButtonPontoAdicionarCancelar.setEnabled(t);        
        
        
        
    }//GEN-LAST:event_jButtonPontoAdicionarNovoActionPerformed

    private void jCheckBoxFuncionarioPontoSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxFuncionarioPontoSimActionPerformed
       
    }//GEN-LAST:event_jCheckBoxFuncionarioPontoSimActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        
    }//GEN-LAST:event_jCheckBox2ActionPerformed
      
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {        
        try {        
            //UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
            //UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
            //UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel"); // Mais bonito no meu ver  (muito escuro)
            //UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");            
            //UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            //UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
            //UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel"); // aprovado para a aplicacao
            //UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
            //UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");            
            //UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
            //UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            //UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel"); //também é legal principalmente os botões
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               if ("".equals(info.getName())) {
                //if ("Nimbus".equals(info.getName())) {
                //if ("Windows".equals(info.getName())) {
                //if ("Metal".equals(info.getName())) {
                //if ("GTK+".equals(info.getName())) { 
                //if ("Mac OS X".equals(info.getName())) {                   
                //if ("CDE/Motif".equals(info.getName())) {                   
                //if ("Windows Classic".equals(info.getName())) {                   
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancelarFuncionario;
    private javax.swing.JButton jButtonCancelarTipo;
    private javax.swing.JButton jButtonEditarCancelarFuncionario;
    private javax.swing.JButton jButtonEditarEditarFuncionario;
    private javax.swing.JButton jButtonEditarExcluirFuncionario;
    private javax.swing.JButton jButtonEditarSalvarFuncionario;
    private javax.swing.JButton jButtonEditarTipo;
    private javax.swing.JButton jButtonExcluirTipo;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonNovoTipo;
    private javax.swing.JButton jButtonPontoAdicionarCancelar;
    private javax.swing.JButton jButtonPontoAdicionarNovo;
    private javax.swing.JButton jButtonPontoAdicionarSalvar;
    private javax.swing.JButton jButtonSalvarFuncionario;
    private javax.swing.JButton jButtonSalvarTipo;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JPanel jCheckBoxFuncionarioPontoNao;
    private javax.swing.JCheckBox jCheckBoxFuncionarioPontoSim;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBoxDescricaoEditarTipoFuncionario;
    private javax.swing.JComboBox<String> jComboBoxEditarTipoFuncionario;
    private javax.swing.JComboBox<String> jComboBoxIdEditarTipoFuncionario;
    private javax.swing.JComboBox<String> jComboBoxIdTipoFuncionario;
    private javax.swing.JComboBox<String> jComboBoxTipoFuncionario;
    private com.toedter.calendar.JDateChooser jDateChooserPonto;
    private javax.swing.JFormattedTextField jFormattedTextFieldEditarValorDiariaFuncionario;
    private javax.swing.JFormattedTextField jFormattedTextFieldValorDiariaFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelVisualizarBairroFuncionario;
    private javax.swing.JLabel jLabelVisualizarCpfFuncionario;
    private javax.swing.JLabel jLabelVisualizarDataNascimentoFuncionario;
    private javax.swing.JTextArea jLabelVisualizarDescricaoFuncionario;
    private javax.swing.JLabel jLabelVisualizarFuncaoFuncionario;
    private javax.swing.JLabel jLabelVisualizarIdadeFuncionario;
    private javax.swing.JLabel jLabelVisualizarIdentificadorFuncionario;
    private javax.swing.JLabel jLabelVisualizarNomeFuncionario;
    private javax.swing.JLabel jLabelVisualizarPeriodoDiasUteisFuncionario;
    private javax.swing.JLabel jLabelVisualizarRuaFuncionario;
    private javax.swing.JLabel jLabelVisualizarSalarioFuncionario;
    private javax.swing.JLabel jLabelVisualizarSexoFuncionario;
    private javax.swing.JLabel jLabelVisualizarTelefone1Funcionario;
    private javax.swing.JLabel jLabelVisualizarTelefone2Funcionario;
    private javax.swing.JLabel jLabelVisualizarValorDiariaFuncionario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButtonEditarFemininoFuncionario;
    private javax.swing.JRadioButton jRadioButtonEditarMasculinoFuncionario;
    private javax.swing.JRadioButton jRadioButtonFemininoFuncionario;
    private javax.swing.JRadioButton jRadioButtonMasculinoFuncionario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPaneFuncionario;
    private javax.swing.JTable jTableFuncionario;
    private javax.swing.JTable jTableFuncionario2;
    private javax.swing.JTable jTableTipo;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextAreaDescricaoDoTipo;
    private javax.swing.JTextArea jTextAreaEditarFuncaoFuncionario;
    private javax.swing.JTextArea jTextAreaFuncaoFuncionario;
    private javax.swing.JTextField jTextFielDiasUteisFuncionario;
    private javax.swing.JTextField jTextFielEditarDiasUteisFuncionario;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextFieldBairroFuncionario;
    private javax.swing.JFormattedTextField jTextFieldCpfFuncionario;
    private com.toedter.calendar.JDateChooser jTextFieldDataNascimentoFuncionario;
    private javax.swing.JTextField jTextFieldEditarBairroFuncionario;
    private javax.swing.JFormattedTextField jTextFieldEditarCpfFuncionario;
    private com.toedter.calendar.JDateChooser jTextFieldEditarDataNascimentoFuncionario;
    private javax.swing.JTextField jTextFieldEditarIdadeFuncionario;
    private javax.swing.JTextField jTextFieldEditarIdentificadorFuncionario;
    private javax.swing.JTextField jTextFieldEditarNomeFuncionario;
    private javax.swing.JTextField jTextFieldEditarRuaFuncionario;
    private javax.swing.JTextField jTextFieldEditarSalarioFuncionario;
    private javax.swing.JFormattedTextField jTextFieldEditarTelefone1Funcionario;
    private javax.swing.JFormattedTextField jTextFieldEditarTelefone2Funcionario;
    private javax.swing.JTextField jTextFieldIdTipo;
    private javax.swing.JTextField jTextFieldIdadeFuncionario;
    private javax.swing.JTextField jTextFieldNomeDoTipo;
    private javax.swing.JTextField jTextFieldNomeFuncionario;
    private javax.swing.JTextField jTextFieldRuaFuncionario;
    private javax.swing.JFormattedTextField jTextFieldSalarioFuncionario;
    private javax.swing.JFormattedTextField jTextFieldTelefone1Funcionario;
    private javax.swing.JFormattedTextField jTextFieldTelefone2Funcionario;
    // End of variables declaration//GEN-END:variables
}