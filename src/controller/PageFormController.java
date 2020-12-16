/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import application_validate.PageFormValidate;
import java.awt.HeadlessException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.*;
import javafx.stage.Stage;
import javafx.util.*;
import javax.swing.JOptionPane;
import model.*;

/**
 * FXML Controller class
 *
 * @author Thinot
 */
public class PageFormController implements Initializable {

    /**
     * Initializes the controller class.
     */
    //PageController Object,Class and Variables Begin
    //Define MenuBar
    @FXML
    MenuBar menuBar = new MenuBar();
    
    //Define Menu
    @FXML
    Menu menuFile = new Menu();
    
    //Define MenuItem
    @FXML
    MenuItem menuItemExitFile = new MenuItem();
    
    //Define Toolbar
    @FXML
    ToolBar toolBar = new ToolBar();

    //Define DatePicker Now
    @FXML
    DatePicker dateNow = new DatePicker();
    
    //Define TabPane
    @FXML
    TabPane tabPage = new TabPane();
    @FXML
    Tab AccueilTab = new Tab();
    @FXML
    Tab LivreTab = new Tab();
    @FXML
    Tab LecteurTab = new Tab();
    @FXML
    Tab PretTab = new Tab();
    @FXML
    Tab OuvrageTab = new Tab();
    @FXML
    Tab SituationLivreTab = new Tab();
    @FXML
    Tab SituationGeneralLivreTab = new Tab();
    //PageFormController Object,Class and Variables End

    //LecteurFormController Object,Class and Variables Begin
    //Define Label
    @FXML
    Label lblNumero = new Label();
    @FXML
    Label lblNom = new Label();
    @FXML
    Label lblSearchLecteur = new Label();
    @FXML
    Label lblNombreLecteur = new Label();

    //Define Tooltip
    @FXML
    Tooltip numero = new Tooltip();
    @FXML
    Tooltip nom = new Tooltip();

    //Define TextField
    @FXML
    TextField txtNumero = new TextField();
    @FXML
    TextField txtNom = new TextField();
    @FXML
    TextField txtSearchLecteur = new TextField();
    @FXML
    TextField txtNombreLecteur = new TextField();

    //Define Button
    @FXML
    Button btnAjouterLecteur = new Button();
    @FXML
    Button btnModifierLecteur = new Button();
    @FXML
    Button btnSupprimerLecteur = new Button();
    @FXML
    Button btnEffacerLecteur = new Button();
    @FXML
    Button btnImprimerLecteur = new Button();
 
    //Define Table
    @FXML
    TableView<LecteurGS> tblLecteur = new TableView<LecteurGS>();
    @FXML
    TableColumn<LecteurGS, String> tblNumero = new TableColumn<LecteurGS, String>();
    @FXML
    TableColumn<LecteurGS, String> tblNom = new TableColumn<LecteurGS, String>();

    //Define Class and Method
    LecteurQuery lq = new LecteurQuery();
    ObservableList<LecteurGS> data = lq.getAllLecteur();
    //LecteurFormController Object,Class and Variables End

    //LivreFormController Object,Class and Variables Begin
    //Define Label
    @FXML
    Label lblNumLivre = new Label();
    @FXML
    Label lblDesignation = new Label();
    @FXML
    Label lblTitre = new Label();
    @FXML
    Label lblAuteur = new Label();
    @FXML
    Label lblDate_Edition = new Label();
    @FXML
    Label lblDisponible = new Label();
    @FXML
    Label lblNombreLivre = new Label();

    //Define Tooltip
    @FXML
    Tooltip tipNumeroLivre = new Tooltip();
    @FXML
    Tooltip tipTitre = new Tooltip();
    @FXML
    Tooltip tipDesignLivre = new Tooltip();
    @FXML
    Tooltip tipAuteurLivre = new Tooltip();
    @FXML
    Tooltip tipDatEditionLivre = new Tooltip();
    @FXML
    Tooltip tipDisponibleLivre = new Tooltip();

    //Define TextField
    @FXML
    TextField txtNumLivre = new TextField();
    @FXML
    TextField txtDesignation = new TextField();
    @FXML
    TextField txtTitre = new TextField();
    @FXML
    TextField txtAuteur = new TextField();
    @FXML
    TextField txtLivreSearch = new TextField();
    @FXML
    TextField txtTitAutSearch = new TextField();
    @FXML
    TextField txtNombreLivre = new TextField();

    //Define DatePicker
    @FXML
    DatePicker txtDateEdition = new DatePicker();

    //Define ComboBox
    @FXML
    ComboBox comboDisponible = new ComboBox();

    //Define RadioButton
    @FXML
    RadioButton rbtnSearchLivre = new RadioButton();
    @FXML
    RadioButton rbtnTitAutSearchLivre = new RadioButton();

    //Define Button
    @FXML
    Button btnAjouterLivre = new Button();
    @FXML
    Button btnModifierLivre = new Button();
    @FXML
    Button btnSupprimerLivre = new Button();
    @FXML
    Button btnEffacerLivre = new Button();

    //Define Table
    @FXML
    TableView<LivreGS> tblLivre = new TableView<LivreGS>();
    @FXML
    TableColumn<LivreGS, String> tblNumLivre = new TableColumn<LivreGS, String>();
    @FXML
    TableColumn<LivreGS, String> tblDesignation = new TableColumn<LivreGS, String>();
    @FXML
    TableColumn<LivreGS, String> tblTitre = new TableColumn<LivreGS, String>();
    @FXML
    TableColumn<LivreGS, String> tblAuteur = new TableColumn<LivreGS, String>();
    @FXML
    TableColumn<LivreGS, String> tblDate_Edition = new TableColumn<LivreGS, String>();
    @FXML
    TableColumn<LivreGS, String> tblDisponible = new TableColumn<LivreGS, String>();

    //Define Class and Method
    LivreQuery livre = new LivreQuery();
    ObservableList<LivreGS> listes = livre.getAllLivre();

    //Define variable
    private final String patternLivre = "yyyy-MM-dd";
    //LivreFormController Object,Class and Variables End

    //PretFormController Object,Class and Variables Begin
    //Define Label
    @FXML
    Label lblNumPret = new Label();
    @FXML
    Label lblLecteurNum = new Label();
    @FXML
    Label lblLivreNum = new Label();
    @FXML
    Label lblDatePret = new Label();
    @FXML
    Label lblDateRetour = new Label();
    @FXML
    Label lblSearchPret = new Label();
    @FXML
    Label lblNombrePret = new Label();
    

    //Define Tooltip
    @FXML
    Tooltip tipNumPret = new Tooltip();
    @FXML
    Tooltip tipLecteurNum = new Tooltip();
    @FXML
    Tooltip tipLivreNum = new Tooltip();
    @FXML
    Tooltip tipDatePre = new Tooltip();
    @FXML
    Tooltip tipDateRet = new Tooltip();

    //Define TextField
    @FXML
    TextField txtNumPret = new TextField();
    @FXML
    TextField txtSearchPret = new TextField();
    @FXML
    TextField txtNombrePret = new TextField();

    //Define ComboBox
    @FXML
    ComboBox comboLecteurNum = new ComboBox();
    @FXML
    ComboBox comboLivreNum = new ComboBox();

    //Define DatePicker
    @FXML
    DatePicker txtDatePret = new DatePicker();
    @FXML
    DatePicker txtDateRetour = new DatePicker();

    //Define Button
    @FXML
    Button btnAjouterPret = new Button();
    @FXML
    Button btnModifierPret = new Button();
    @FXML
    Button btnSupprimerPret = new Button();
    @FXML
    Button btnEffacerPret = new Button();
    @FXML
    Button btnSearchPret = new Button();
    @FXML
    Button btnImprimerPret = new Button();

    //Define Table
    @FXML
    TableView<PretGS> tblPret = new TableView<PretGS>();
    @FXML
    TableColumn<PretGS, String> tblNumPret = new TableColumn<PretGS, String>();
    @FXML
    TableColumn<PretGS, String> tblLecteurNum = new TableColumn<PretGS, String>();
    @FXML
    TableColumn<PretGS, String> tblLivreNum = new TableColumn<PretGS, String>();
    @FXML
    TableColumn<PretGS, String> tblDatePret = new TableColumn<PretGS, String>();
    @FXML
    TableColumn<PretGS, String> tblDateRetour = new TableColumn<PretGS, String>();

    //Define Class and Method
    PretQuery pret = new PretQuery();
    final ObservableList<PretGS> pretList = pret.getAllPret();

    //Define variables
    private final String patternPret = "yyyy-MM-dd";
    //PretFormController Object,Class and Variables End

    //OuvrageFormController Object,Class and Variable Begin
    //Define Label
    @FXML
    Label lblNombreLivrePret = new Label();

    //Define TextField
    @FXML
    TextField txtNombreOuvrage = new TextField();
    @FXML
    TextField txtSearchYear = new TextField();
    @FXML
    TextField txtSearchYearsList = new TextField();
       @FXML
    Button btnImprimerOuvrage = new Button();

    //Define ComboBox
    @FXML
    ComboBox comboMonthOuvrage = new ComboBox();

    //Define DatePicker
    @FXML
    DatePicker txtDatePretDeb = new DatePicker();
    @FXML
    DatePicker txtDatePretFin = new DatePicker();

    //Define Tooltip
    @FXML
    Tooltip tipMonthOuvrage = new Tooltip();
    @FXML
    Tooltip tipYearOuvrage = new Tooltip();
    @FXML
    Tooltip tipYearSearchOuvrage = new Tooltip();
    @FXML
    Tooltip tipDatePretDeb = new Tooltip();
    @FXML
    Tooltip tipDatePretFin = new Tooltip();

    //Define Button
    @FXML
    Button btnYearMonthSearch = new Button();
    @FXML
    Button btnYearSearch = new Button();
    @FXML
    Button btnEntreDeuxDatePretSearch = new Button();

    //Define RadioButton
    @FXML
    RadioButton rbtnMonthOuvrageList = new RadioButton();
    @FXML
    RadioButton rbtnYearOuvrageList = new RadioButton();
    @FXML
    RadioButton rbtnBetweenTwoDateOuvrageList = new RadioButton();

    //Define Table
    @FXML
    TableView<OuvrageGS> tblOuvrage = new TableView<OuvrageGS>();
    @FXML
    TableColumn<OuvrageGS, String> tblNumLecteur = new TableColumn<OuvrageGS, String>();
    @FXML
    TableColumn<OuvrageGS, String> tblNomLecteur = new TableColumn<OuvrageGS, String>();
    @FXML
    TableColumn<OuvrageGS, String> tblDesignationOuvrage = new TableColumn<OuvrageGS, String>();
    @FXML
    TableColumn<OuvrageGS, String> tblTitreOuvrage = new TableColumn<OuvrageGS, String>();
    @FXML
    TableColumn<OuvrageGS, String> tblAuteurOuvrage = new TableColumn<OuvrageGS, String>();
    @FXML
    TableColumn<OuvrageGS, String> tblDateEditionOuvrage = new TableColumn<OuvrageGS, String>();
    @FXML
    TableColumn<OuvrageGS, String> tblDatePretOuvrage = new TableColumn<OuvrageGS, String>();
    @FXML
    TableColumn<OuvrageGS, String> tblDateRetourOuvrage = new TableColumn<OuvrageGS, String>();
    @FXML
    TableColumn<OuvrageGS, String> tblAmendeOuvrage = new TableColumn<OuvrageGS, String>();
    //Define Class and Method
    OuvrageQuery Ouvrage = new OuvrageQuery();
    ObservableList<OuvrageGS> ListOuvrage = Ouvrage.getAllOuvrage();

    //Define Variable
    private String moisSelection = "";
    //OuvrageFormController Object,Class and Variables End

    //SituationLivreFormController Object,Class and Variables Begin
    //Define Button
    @FXML
    Button btnListeSituationLivre = new Button();
    @FXML
    Button btnDiagrammeCirculaireLivreSituation = new Button();
    @FXML
    Button btnDiagrammeBattonLivreSituation = new Button();
    @FXML
    Button btnDiagrammeLineaireLivreSituation = new Button();

    //Define Table
    @FXML
    TableView<SituationLivreGS> tblSituationLivre = new TableView<SituationLivreGS>();
    @FXML
    TableColumn<SituationLivreGS, String> tblNumLivreSituation = new TableColumn<SituationLivreGS, String>();
    @FXML
    TableColumn<SituationLivreGS, String> tblDesignationSituation = new TableColumn<SituationLivreGS, String>();
    @FXML
    TableColumn<SituationLivreGS, String> tblTitreSituation = new TableColumn<SituationLivreGS, String>();
    @FXML
    TableColumn<SituationLivreGS, String> tblAuteurSituation = new TableColumn<SituationLivreGS, String>();
    @FXML
    TableColumn<SituationLivreGS, String> tblDateEditionSituation = new TableColumn<SituationLivreGS, String>();
    @FXML
    TableColumn<SituationLivreGS, String> tblDisponibleSituation = new TableColumn<SituationLivreGS, String>();
    @FXML
    TableColumn<SituationLivreGS, String> tblNbFoisPretSituation = new TableColumn<SituationLivreGS, String>();

    //Define Class and Method
    SituationLivreQuery situationLivre = new SituationLivreQuery();
    ObservableList<SituationLivreGS> ListSituationLivre = situationLivre.getAllSituationLivre();
    //SituationLivreFormController Object,Class and Variables End

    //SituationGeneralFormController Object,Class and Variables Begin
    //Define Button
    @FXML
    Button btnDiagrammeCirculaireLivreGeneralSituation = new Button();
    @FXML
    Button btnDiagrammeBattonLivreGeneralSituation = new Button();
    //Define Table
    @FXML
    TableView<SituationLivreGS> tblSituationGeneralLivre = new TableView();
    @FXML
    TableColumn<SituationLivreGS, String> tblSituationDesignation = new TableColumn<SituationLivreGS, String>();
    @FXML
    TableColumn<SituationLivreGS, String> tblSituationNbFoisPret = new TableColumn<SituationLivreGS, String>();
    
    //Define Class and Method
    ObservableList<SituationLivreGS> ListSituationGeneralLivre = situationLivre.getAllSituationGeneralLivre();
    //SituationGeneralFormController Object,Class and Variables End
    
    //PageFormController Constructor Begin
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       menuItemExitFile();
        DatePickerToolBarNow();
        initializeLecteur();
        initializeLivre();
        initializePret();
        initializeOuvrage();
        initializeSituationLivre();
        initializeSituationGeneralLivre();
    }
    //End of PageFormController Constructor

    //PageFormController Action Begin

    public void menuItemExitFile(){
        menuItemExitFile.setMnemonicParsing(true);
        menuItemExitFile.setAccelerator(new KeyCodeCombination(KeyCode.X,KeyCombination.CONTROL_DOWN));
        menuItemExitFile.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
    }
    
    public void TabClickedAccueil() {
        System.out.println("Accueil");
    }

    public void TabClickedLecteur() {
        System.out.println("Lecteur");
    }

    public void TabClickedLivre() {
        System.out.println("Livre");
    }

    public void TabClickedPret() {
        comboNumLecteurList();
        comboNumLivreList();
    }

    public void TabClickedOuvrage() {
        btnListesOuvrage();
        btnNombreOuvrage();
    }

    public void TabClickedSituationLivre() {
        btnListeSituationLivre();
    }

    public void TabClickedSituationGeneralLivre() {
        btnListSituationGeneralLivre();
    }
    
    private void DatePickerToolBarNow() {
        dateNow.setValue(LocalDate.now());
        StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(patternLivre);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        dateNow.setConverter(converter);
        dateNow.setPromptText(patternLivre.toLowerCase());
    }
    
    //PageFormController Action End

    //LecteurFormController Action begin
    public void initializeLecteur() {
        tblNumero.setCellValueFactory(new PropertyValueFactory<LecteurGS, String>("Numero"));
        tblNom.setCellValueFactory(new PropertyValueFactory<LecteurGS, String>("Nom"));
        tblLecteur.setItems(data);
        btnNombreLecteur();
    }

    public void btnAjouterLecteur() {
        try {
            if (ValidateFormLecteur()) {
                LecteurGS entry = new LecteurGS(txtNumero.getText(), txtNom.getText());
                lq.AjouterLecteur(entry);
                btnListesLecteur();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "erreur");
        }

    }

    public void btnModifierLecteur() {
        try {
            if (!"".equals(txtNumero.getText()) && !"".equals(txtNom.getText())) {
                if(JOptionPane.showConfirmDialog(null, "Voulez-vous modifier cet enregistrement","Modification",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
                LecteurGS edit = new LecteurGS(txtNumero.getText(), txtNom.getText());
                lq.ModifierLecteur(edit);
                btnListesLecteur();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Veuillez selectionnez une liste");
            }
        } catch (HeadlessException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void btnSupprimerLecteur() {
        try {
            if (!"".equals(txtNumero.getText()) && !"".equals(txtNom.getText())) {
                if(JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cet enregistrement","Suppression",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
                LecteurGS delete = new LecteurGS(txtNumero.getText());
                lq.SupprimerLecteur(delete);
                btnListesLecteur();
                }     
            }
            else {
                JOptionPane.showMessageDialog(null, "Veuillez selectionnez une liste");
            }
        } catch (HeadlessException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void btnListesLecteur() {
        btnEffacerLecteur();
        txtSearchLecteur.clear();
        ObservableList<LecteurGS> data = lq.getAllLecteur();
        tblLecteur.setItems(data);
        btnNombreLecteur();
    }

    public void btnSearchLecteur() {
        String entry = txtSearchLecteur.getText();
        ObservableList<LecteurGS> lists = lq.RechercherLecteur(entry);
        tblLecteur.setItems(lists);
        btnNombreLecteurSearch();
        btnEffacerLecteur();
    }
    
    public void btnNombreLecteur(){
        ObservableList<String> nombreLecteur = lq.getAllNombreLecteur();
        txtNombreLecteur.setText(nombreLecteur.toString());
    }

    public void btnNombreLecteurSearch(){
        ObservableList<String> nombreLecteurSearch = lq.getAllNombreLecteurSearch(txtSearchLecteur.getText());
        txtNombreLecteur.setText(nombreLecteurSearch.toString());
    }
    
    public void tblMouseClickedLecteur() {
        String i = tblLecteur.getSelectionModel().selectedItemProperty().getValue().getNumero();
        String j = tblLecteur.getSelectionModel().selectedItemProperty().getValue().getNom();
        txtNumero.setText(i);
        txtNom.setText(j);
    }

    public boolean ValidateFormLecteur() {
        boolean number = PageFormValidate.TextFieldNotEmpty(txtNumero, numero, "Numero is required");
        boolean name = PageFormValidate.TextFieldNotEmpty(txtNom, nom, "Nom is required");
        boolean c = false;
        if (number && name) {
            c = true;
        }
        return c;
    }

    public void btnEffacerLecteur() {
        txtNumero.clear();
        txtNom.clear();
    }
    //LecteurFormController Action End

    //LivreFormController Action Begin
    public void initializeLivre() {
        tblNumLivre.setCellValueFactory(new PropertyValueFactory<LivreGS, String>("numLivre"));
        tblDesignation.setCellValueFactory(new PropertyValueFactory<LivreGS, String>("Designation"));
        tblTitre.setCellValueFactory(new PropertyValueFactory<LivreGS, String>("Titre"));
        tblAuteur.setCellValueFactory(new PropertyValueFactory<LivreGS, String>("Auteur"));
        tblDate_Edition.setCellValueFactory(new PropertyValueFactory<LivreGS, String>("DateEdition"));
        tblDisponible.setCellValueFactory(new PropertyValueFactory<LivreGS, String>("Disponible"));
        tblLivre.setItems(listes);
        DatePickerLivre();
        comboDisponible();
        rbtnSearchLivre();
        btnNombreLivre();
    }

    public void btnAjouterLivre() {
        if (ValidateFormLivre()) {
            LivreGS entry = new LivreGS(txtNumLivre.getText(), txtDesignation.getText(), txtTitre.getText(), txtAuteur.getText(), txtDateEdition.getEditor().getText(), comboDisponible.getValue().toString());
            livre.AjouterLivre(entry);
            btnListesLivre();
        }
    }

    public void btnModifierLivre() {
        if (ValidateFormLivre()) {
            if(JOptionPane.showConfirmDialog(null, "Voulez-vous modifier cet enregistrement","Modification",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
            LivreGS edit = new LivreGS(txtNumLivre.getText(), txtDesignation.getText(), txtTitre.getText(), txtAuteur.getText(), txtDateEdition.getEditor().getText(), comboDisponible.getValue().toString());
            livre.ModifierLivre(edit);
            btnListesLivre();
            }
        }
        else {
                JOptionPane.showMessageDialog(null, "Veuillez selectionnez une liste");
            }
    }

    public void btnSupprimerLivre() {
       if (ValidateFormLivre()) {
       if(JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cet enregistrement","Suppression",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
        LivreGS delete = new LivreGS(txtNumLivre.getText());
        livre.SupprimerLivre(delete);
        btnListesLivre();   
        }
       }
       else {
                JOptionPane.showMessageDialog(null, "Veuillez selectionnez une liste");
            }
    }

    public void btnListesLivre() {
        btnEffacerLivre();
        ObservableList<LivreGS> refresh = livre.getAllLivre();
        tblLivre.setItems(refresh);
        btnNombreLivre();
    }

    public void btnSearchLivre() {
        String search = txtLivreSearch.getText();
        ObservableList<LivreGS> searchLivre = livre.RechercherLivre(search);
        tblLivre.setItems(searchLivre);
        btnNombreLivreGeneralSearch();
        btnEffacerLivre();
    }

    public void btnTitAutSearchLivre() {
        String tittle = txtTitAutSearch.getText();
        ObservableList<LivreGS> titreListe = livre.getTitreLivre(tittle);
        tblLivre.setItems(titreListe);
        btnNombreLivreTitAutSearch();
        btnEffacerLivre();
    }

    public void rbtnSearchLivre() {
        try {
            btnListesLivre();
            btnNombreLivre();
            rbtnSearchLivre.selectedProperty().set(true);
            txtLivreSearch.setVisible(true);
            txtTitAutSearch.setVisible(false);
            txtTitAutSearch.clear();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "diso kely");
        }

    }

    public void rbtnTitAutSearchLivre() {
        try {
            btnListesLivre();
            btnNombreLivre();
            txtTitAutSearch.setVisible(true);
            txtLivreSearch.setVisible(false);
            txtLivreSearch.clear();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "diso kely");
        }

    }

    public void btnNombreLivre() {
        try {
            ObservableList<String> nombre = livre.getAllNombreLivre();
            txtNombreLivre.setText(nombre.toString());
            txtNombreLivre.setEditable(false);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void btnNombreLivreGeneralSearch() {
        try {
            ObservableList<String> nombreLivreGeneralSearch = livre.getAllNombreLivreGeneralSearch(txtLivreSearch.getText());
            txtNombreLivre.setText(nombreLivreGeneralSearch.toString());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void btnNombreLivreTitAutSearch() {
        try {
            ObservableList<String> nomLivreTitAutSearch = livre.getAllNombreLivreTitAutSearch(txtTitAutSearch.getText());
            txtNombreLivre.setText(nomLivreTitAutSearch.toString());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void tblMouseClickedLivre() {
        txtNumLivre.setText(tblLivre.getSelectionModel().selectedItemProperty().getValue().getNumLivre());
        txtDesignation.setText(tblLivre.getSelectionModel().selectedItemProperty().getValue().getDesignation());
        txtTitre.setText(tblLivre.getSelectionModel().selectedItemProperty().getValue().getTitre());
        txtAuteur.setText(tblLivre.getSelectionModel().selectedItemProperty().getValue().getAuteur());
        txtDateEdition.getEditor().setText(tblLivre.getSelectionModel().selectedItemProperty().getValue().getDateEdition());
        comboDisponible.setValue(tblLivre.getSelectionModel().selectedItemProperty().getValue().getDisponible());
    }

    public void comboDisponible() {
        ObservableList<String> listDispo = FXCollections.observableArrayList("Oui", "Non");
        comboDisponible.getItems().addAll(listDispo);
    }

    public boolean ValidateFormLivre() {
        boolean numeroLivre = PageFormValidate.TextFieldNotEmpty(txtNumLivre, tipNumeroLivre, "Numero is required");
        boolean designation = PageFormValidate.TextFieldNotEmpty(txtDesignation, tipDesignLivre, "Designation is required");
        boolean titre = PageFormValidate.TextFieldNotEmpty(txtTitre, tipTitre, "Titre is required");
        boolean auteur = PageFormValidate.TextFieldNotEmpty(txtAuteur, tipAuteurLivre, "Auteur is required");
        boolean dateEdition = PageFormValidate.DatePickerNotEmpty(txtDateEdition, tipDatEditionLivre, "Date Edition is required");
        boolean disponible = PageFormValidate.ComboBoxNotEmpty(comboDisponible, tipDisponibleLivre, "Disponible is required");
        boolean r = false;
        if (numeroLivre && designation && titre && auteur && dateEdition && disponible) {
            r = true;
        }
        return r;
    }

    public void btnEffacerLivre() {
        txtNumLivre.clear();
        txtDesignation.clear();
        txtTitre.clear();
        txtAuteur.clear();
        txtDateEdition.getEditor().clear();
        comboDisponible.setValue("");
    }

    private void DatePickerLivre() {
        txtDateEdition.setValue(LocalDate.now());
        StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(patternLivre);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        txtDateEdition.setConverter(converter);
        txtDateEdition.setPromptText(patternLivre.toLowerCase());
    }
    //LivreFormController Action End

    //PretFormController Action Begin
    public void initializePret() {
        tblNumPret.setCellValueFactory(new PropertyValueFactory<PretGS, String>("numPret"));
        tblLecteurNum.setCellValueFactory(new PropertyValueFactory<PretGS, String>("LecteurNum"));
        tblLivreNum.setCellValueFactory(new PropertyValueFactory<PretGS, String>("LivreNum"));
        tblDatePret.setCellValueFactory(new PropertyValueFactory<PretGS, String>("DatePret"));
        tblDateRetour.setCellValueFactory(new PropertyValueFactory<PretGS, String>("DateRetour"));
        tblPret.setItems(pretList);
        comboNumLecteurList();
        comboNumLivreList();
        DatePickerPret();
        btnNombrePret();
    }

    public void btnAjouterPret() {
        if (ValidateFormPret()) {
            PretGS entry = new PretGS(txtNumPret.getText(), comboLecteurNum.getValue().toString(), comboLivreNum.getValue().toString(), txtDatePret.getEditor().getText(), txtDateRetour.getEditor().getText());
            pret.AjouterPret(entry);
            btnListesPret();
        }
    }

    public void btnModifierPret() {
        if (ValidateFormPret()) {
            if(JOptionPane.showConfirmDialog(null, "Voulez-vous modifier cet enregistrement","Modification",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
            PretGS edit = new PretGS(txtNumPret.getText(), comboLecteurNum.getValue().toString(), comboLivreNum.getValue().toString(), txtDatePret.getEditor().getText(), txtDateRetour.getEditor().getText());
            pret.ModifierPret(edit);
            btnListesPret();
            }
        }
        else {
                JOptionPane.showMessageDialog(null, "Veuillez selectionnez une liste");
            }
    }

    public void btnSupprimerPret() {
        if (ValidateFormPret()) {
        if(JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cet enregistrement","Suppression",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
        PretGS delete = new PretGS(txtNumPret.getText());
        pret.SupprimerPret(delete);
        btnListesPret();
        }
        }
        else {
                JOptionPane.showMessageDialog(null, "Veuillez selectionnez une liste");
            }
    }

    public void btnListesPret() {
        btnEffacerPret();
        ObservableList<PretGS> refresh = pret.getAllPret();
        tblPret.setItems(refresh);
        btnNombrePret();
    }

    public void btnSearchPret() {
        String txtSearch = txtSearchPret.getText();
        ObservableList<PretGS> listPret = pret.RechercherPret(txtSearch);
        tblPret.setItems(listPret);
        btnNombrePretSearch();
    }

    public void btnNombrePret(){
        ObservableList<String> nombrePret = pret.getAllNombrePret();
        txtNombrePret.setText(nombrePret.toString());
    }
    
    public void btnNombrePretSearch(){
        ObservableList<String> nombrePret = pret.getAllNombrePretSearch(txtSearchPret.getText());
        txtNombrePret.setText(nombrePret.toString());
    }
    
    public void tblMouseClickedPret() {
        txtNumPret.setText(tblPret.getSelectionModel().selectedItemProperty().getValue().getNumPret());
        comboLecteurNum.setValue(tblPret.getSelectionModel().selectedItemProperty().getValue().getLecteurNum());
        comboLivreNum.setValue(tblPret.getSelectionModel().selectedItemProperty().getValue().getLivreNum());
        txtDatePret.getEditor().setText(tblPret.getSelectionModel().selectedItemProperty().getValue().getDatePret());
        txtDateRetour.getEditor().setText(tblPret.getSelectionModel().selectedItemProperty().getValue().getDateRetour());
    }

    public void comboNumLecteurList() {
        ObservableList<String> lecteurNumero = pret.getAllLecteurNum();
        comboLecteurNum.setItems(lecteurNumero);
    }

    public void comboNumLivreList() {
        ObservableList<String> livreNumero = pret.getAllLivreNum();
        comboLivreNum.setItems(livreNumero);

    }

    public boolean ValidateFormPret() {
        boolean numPret = PageFormValidate.TextFieldNotEmpty(txtNumPret, tipNumPret, "Numero Pret is required");
        boolean numLecteur = PageFormValidate.ComboBoxNotEmpty(comboLecteurNum, tipLecteurNum, "Numero Lecteur is required");
        boolean LivreNum = PageFormValidate.ComboBoxNotEmpty(comboLivreNum, tipLivreNum, "Numero Livre is required");
        boolean datePre = PageFormValidate.DatePickerNotEmpty(txtDatePret, tipDatePre, "Date Pret is required");
        boolean dateRet = PageFormValidate.DatePickerNotEmpty(txtDateRetour, tipDateRet, "Date Retour is required");

        boolean c = false;
        if (numPret && numLecteur && LivreNum && datePre && dateRet) {
            c = true;
        }
        return c;
    }

    public void btnEffacerPret() {
        txtNumPret.clear();
        comboLecteurNum.setValue("");
        comboLivreNum.setValue("");
        txtDatePret.getEditor().clear();
        txtDateRetour.getEditor().clear();
    }

    public void DatePickerPret() {

        txtDatePret.setValue(LocalDate.now());

        StringConverter converter = new StringConverter<LocalDate>() {

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(patternPret);

            @Override
            public String toString(LocalDate dat) {
                if (dat != null) {
                    return dateFormatter.format(dat);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }

        };
        txtDatePret.setConverter(converter);
        txtDatePret.setPromptText(patternPret.toLowerCase());
        txtDateRetour.setConverter(converter);
        txtDateRetour.setPromptText(patternPret.toLowerCase());

        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item.isBefore(txtDatePret.getValue().plusDays(7))) {
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }

                    }
                };
            }
        };
        txtDateRetour.setDayCellFactory(dayCellFactory);
        txtDateRetour.setValue(txtDatePret.getValue().plusDays(7));
    }
    //PretFormController Action End

    //OuvrageFormController Action Begin
    public void initializeOuvrage() {
        tblNumLecteur.setCellValueFactory(new PropertyValueFactory<OuvrageGS, String>("numLecteur"));
        tblNomLecteur.setCellValueFactory(new PropertyValueFactory<OuvrageGS, String>("nom"));
        tblDesignationOuvrage.setCellValueFactory(new PropertyValueFactory<OuvrageGS, String>("Designation"));
        tblTitreOuvrage.setCellValueFactory(new PropertyValueFactory<OuvrageGS, String>("Titre"));
        tblAuteurOuvrage.setCellValueFactory(new PropertyValueFactory<OuvrageGS, String>("Auteur"));
        tblDateEditionOuvrage.setCellValueFactory(new PropertyValueFactory<OuvrageGS, String>("DateEdition"));
        tblDatePretOuvrage.setCellValueFactory(new PropertyValueFactory<OuvrageGS, String>("DatePret"));
        tblDateRetourOuvrage.setCellValueFactory(new PropertyValueFactory<OuvrageGS, String>("DateRetour"));
        tblAmendeOuvrage.setCellValueFactory(new PropertyValueFactory<OuvrageGS, String>("Amende"));
        tblOuvrage.setItems(ListOuvrage);
        DatePickerOuvrage();
        comboMonthOuvrage();
        rbtnMonthOuvrageList();
    }

    public void btnListesOuvrage() {
        ObservableList<OuvrageGS> list = Ouvrage.getAllOuvrage();
        tblOuvrage.setItems(list);
        btnNombreOuvrage();
        txtDatePretDeb.getEditor().setText("");
        txtDatePretFin.getEditor().setText("");
    }

    public void btnNombreOuvrage() {
        try {
            ObservableList<String> nombrePret = Ouvrage.getAllNombrePret();
            txtNombreOuvrage.setText(nombrePret.toString());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void btnNombreOuvrageBetweenTwoDate() {
        try {
            ObservableList<String> nombrePret = Ouvrage.getAllNombrePretBetwenTwoDate(txtDatePretDeb.getValue().toString(), txtDatePretFin.getValue().toString());
            txtNombreOuvrage.setText(nombrePret.toString());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void btnNombreOuvrageYear() {
        try {
            ObservableList<String> nombrePret = Ouvrage.getAllNombrePretYear(txtSearchYear.getText());
            txtNombreOuvrage.setText(nombrePret.toString());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void btnNombreOuvrageYearMonth() {
        try {
            ObservableList<String> nombrePret = Ouvrage.getAllNombrePretYearMonth(moisSelection, txtSearchYearsList.getText());
            txtNombreOuvrage.setText(nombrePret.toString());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void btnEntreDeuxDatePretSearch() {
        try {
            if (ValidateBetweenTwoDateFormOuvrage()) {
                String datEditionDeb = txtDatePretDeb.getValue().toString();
                String datEditionFin = txtDatePretFin.getValue().toString();
                ObservableList<OuvrageGS> listsearch = Ouvrage.RechercherOuvrage(datEditionDeb, datEditionFin);
                tblOuvrage.setItems(listsearch);
                btnNombreOuvrageBetweenTwoDate();
                txtDatePretDeb.getEditor().setText("");
                txtDatePretFin.getEditor().setText("");
            }
        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());
        }

    }

    public void DatePickerOuvrage() {

        txtDatePretDeb.setValue(LocalDate.now());

        StringConverter converter = new StringConverter<LocalDate>() {

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(patternPret);

            @Override
            public String toString(LocalDate dat) {
                if (dat != null) {
                    return dateFormatter.format(dat);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }

        };
        txtDatePretDeb.setConverter(converter);
        txtDatePretDeb.setPromptText(patternPret.toLowerCase());
        txtDatePretFin.setConverter(converter);
        txtDatePretFin.setPromptText(patternPret.toLowerCase());

        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item.isBefore(txtDatePretDeb.getValue().plusDays(1))) {
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }

                    }
                };
            }
        };
        txtDatePretFin.setDayCellFactory(dayCellFactory);
        txtDatePretFin.setValue(txtDatePretDeb.getValue().plusDays(1));
    }

    public void btnYearSearch() {
        try {
            if (ValidateYearFormOuvrage()) {
                String YearEntry = txtSearchYear.getText();
                ObservableList<OuvrageGS> listOuvrageYear = Ouvrage.getYearsOuvrageList(YearEntry);
                tblOuvrage.setItems(listOuvrageYear);
                btnNombreOuvrageYear();
                txtSearchYear.clear();
            }

        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());
        }

    }

    public void comboMonthOuvrage() {
        ObservableList<String> listesOuvrage = FXCollections.observableArrayList("Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Decembre");
        comboMonthOuvrage.setItems(listesOuvrage);
    }

    public void OuvrageMonthSelectionned() {
        switch (comboMonthOuvrage.getValue().toString()) {
            case "Janvier":
                comboMonthOuvrage.getValue().equals("Janvier");
                moisSelection = "01";
                break;
            case "Fevrier":
                comboMonthOuvrage.getValue().equals("Fevrier");
                moisSelection = "02";
                break;
            case "Mars":
                comboMonthOuvrage.getValue().equals("Mars");
                moisSelection = "03";
                break;
            case "Avril":
                comboMonthOuvrage.getValue().equals("Avril");
                moisSelection = "04";
                break;
            case "Mai":
                comboMonthOuvrage.getValue().equals("Mai");
                moisSelection = "05";
                break;
            case "Juin":
                comboMonthOuvrage.getValue().equals("Juin");
                moisSelection = "06";
                break;
            case "Juillet":
                comboMonthOuvrage.getValue().equals("Juillet");
                moisSelection = "07";
                break;
            case "Août":
                comboMonthOuvrage.getValue().equals("Août");
                moisSelection = "08";
                break;
            case "Septembre":
                comboMonthOuvrage.getValue().equals("Septembre");
                moisSelection = "09";
                break;
            case "Octobre":
                comboMonthOuvrage.getValue().equals("Octobre");
                moisSelection = "10";
                break;
            case "Novembre":
                comboMonthOuvrage.getValue().equals("Novembre");
                moisSelection = "11";
                break;
            case "Decembre":
                comboMonthOuvrage.getValue().equals("Decembre");
                moisSelection = "12";
                break;
            default:
                System.out.println("erreur");
                break;
        }

    }

    public void btnYearMonthSearch() {
        try {
            if (ValidateYearMonthFormOuvrage()) {
                OuvrageMonthSelectionned();
                ObservableList<OuvrageGS> list = Ouvrage.getYearsMonthOuvrageList(moisSelection, txtSearchYearsList.getText());
                tblOuvrage.setItems(list);
                btnNombreOuvrageYearMonth();
                comboMonthOuvrage.setValue("");
                txtSearchYearsList.clear();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "erreur be");
        }
    }

    public void rbtnMonthOuvrageList() {
        try {
            btnListesOuvrage();
            btnNombreOuvrage();
            rbtnMonthOuvrageList.selectedProperty().set(true);
            comboMonthOuvrage.setVisible(true);
            txtSearchYearsList.setVisible(true);
            btnYearMonthSearch.setVisible(true);
            txtSearchYear.setVisible(false);
            txtDatePretDeb.setVisible(false);
            txtDatePretFin.setVisible(false);
            btnYearSearch.setVisible(false);
            btnEntreDeuxDatePretSearch.setVisible(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "diso kely");
        }
    }

    public void rbtnYearOuvrageList() {
        try {
            btnListesOuvrage();
            btnNombreOuvrage();
            txtSearchYear.setVisible(true);
            btnYearSearch.setVisible(true);
            txtDatePretFin.setVisible(false);
            comboMonthOuvrage.setVisible(false);
            txtSearchYearsList.setVisible(false);
            txtDatePretDeb.setVisible(false);
            btnYearMonthSearch.setVisible(false);
            btnEntreDeuxDatePretSearch.setVisible(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "diso kely");
        }
    }

    public void rbtnBetweenTwoDateOuvrageList() {
        try {
            btnListesOuvrage();
            btnNombreOuvrage();
            txtDatePretDeb.setVisible(true);
            txtDatePretFin.setVisible(true);
            btnEntreDeuxDatePretSearch.setVisible(true);
            txtSearchYear.setVisible(false);
            btnYearSearch.setVisible(false);
            comboMonthOuvrage.setVisible(false);
            txtSearchYearsList.setVisible(false);
            btnYearMonthSearch.setVisible(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "diso kely");
        }
    }

    public boolean ValidateYearMonthFormOuvrage() {
        boolean ouvrageMonth = PageFormValidate.ComboBoxNotEmpty(comboMonthOuvrage, tipMonthOuvrage, "month is required");
        boolean ouvrageYear = PageFormValidate.TextFieldNotEmpty(txtSearchYearsList, tipYearOuvrage, "year is required");
        boolean r = false;
        if (ouvrageMonth && ouvrageYear) {
            r = true;
        }
        return r;
    }

    public boolean ValidateYearFormOuvrage() {
        boolean ouvrageYear = PageFormValidate.TextFieldNotEmpty(txtSearchYear, tipYearSearchOuvrage, "year is required");
        boolean r = false;
        if (ouvrageYear) {
            r = true;
        }
        return r;
    }

    public boolean ValidateBetweenTwoDateFormOuvrage() {
        boolean datPretDebOuvrage = PageFormValidate.DatePickerNotEmpty(txtDatePretDeb, tipDatePretDeb, "Date PretDeb is required");
        boolean datPretFinOuvrage = PageFormValidate.DatePickerNotEmpty(txtDatePretFin, tipDatePretFin, "Date PretFin is required");
        boolean r = false;
        if (datPretDebOuvrage && datPretFinOuvrage) {
            r = true;
        }
        return r;
    }
    //OuvrageFormController Action End

    //SituationLivreFormController Action Begin
    public void initializeSituationLivre() {
        tblNumLivreSituation.setCellValueFactory(new PropertyValueFactory<SituationLivreGS, String>("numLivre"));
        tblDesignationSituation.setCellValueFactory(new PropertyValueFactory<SituationLivreGS, String>("Designation"));
        tblTitreSituation.setCellValueFactory(new PropertyValueFactory<SituationLivreGS, String>("Titre"));
        tblAuteurSituation.setCellValueFactory(new PropertyValueFactory<SituationLivreGS, String>("Auteur"));
        tblDateEditionSituation.setCellValueFactory(new PropertyValueFactory<SituationLivreGS, String>("DateEdition"));
        tblDisponibleSituation.setCellValueFactory(new PropertyValueFactory<SituationLivreGS, String>("Disponible"));
        tblNbFoisPretSituation.setCellValueFactory(new PropertyValueFactory<SituationLivreGS, String>("NbFoisPret"));
        tblSituationLivre.setItems(ListSituationLivre);
    }

    public void btnListeSituationLivre() {
        ObservableList<SituationLivreGS> situationList = situationLivre.getAllSituationLivre();
        tblSituationLivre.setItems(situationList);
    }

    public void btnDiagrammeCirculaireLivreSituation() {
        Stage stage = new Stage();
        Scene scene = new Scene(new Group());
        stage.setTitle("Diagramme Circulaire");
        stage.setWidth(500);
        stage.setHeight(500);
        ObservableList<PieChart.Data> pieChartData = situationLivre.DiagrammeCirculaireLivreSituation();
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Pourcentage des livres");
        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }

    public void btnDiagrammeLineaireLivreSituation() {
        Stage stage = new Stage();
        stage.setTitle("Diagramme Lineaire");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Liste des livres");
        final LineChart<String, Number> lineChart = situationLivre.DiagrammeLineaireLivreSituation(xAxis, yAxis);
        lineChart.setTitle("Statistique des Livres pretés");
        Scene scene = new Scene(lineChart, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void btnDiagrammeBattonLivreSituation() {
        Stage stage = new Stage();
        stage.setTitle("Diagramme en Batton");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> barChart = situationLivre.DiagrammeBattonLivreSituation(xAxis, yAxis);
        barChart.setTitle("");
        xAxis.setLabel("Liste de livres");
        yAxis.setLabel("Nombre de livres pretés");
        Scene scene = new Scene(barChart, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
    //SituationLivreFormController Action End
    
    
    //SituationGeneralLivreFormController Action begin
    public void initializeSituationGeneralLivre(){
        tblSituationDesignation.setCellValueFactory(new PropertyValueFactory<SituationLivreGS, String>("Designation"));
        tblSituationNbFoisPret.setCellValueFactory(new PropertyValueFactory<SituationLivreGS, String>("NbFoisPret"));
        tblSituationGeneralLivre.setItems(ListSituationGeneralLivre);
    }
    //SituationGeneralLivreFormController Action End

    public void btnListSituationGeneralLivre() {
         ObservableList<SituationLivreGS> situationGeneralList = situationLivre.getAllSituationGeneralLivre();
         tblSituationGeneralLivre.setItems(situationGeneralList);
    }
    
    public void btnDiagrammeCirculaireLivreGeneralSituation(){
        Stage stage = new Stage();
        Scene scene = new Scene(new Group());
        stage.setTitle("Diagramme Circulaire");
        stage.setWidth(500);
        stage.setHeight(500);
        ObservableList<PieChart.Data> pieChartData = situationLivre.DiagrammeCirculaireLivreGeneralSituation();
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Pourcentage des livres");
        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }
    
    public void btnDiagrammeBattonLivreGeneralSituation(){
        Stage stage = new Stage();
        stage.setTitle("Diagramme en Batton");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> barChart = situationLivre.DiagrammeBattonLivreGeneralSituation(xAxis, yAxis);
        barChart.setTitle("");
        xAxis.setLabel("Liste de livres");
        yAxis.setLabel("Nombre de livres pretés");
        Scene scene = new Scene(barChart, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
    
    public void btnImprimerLecteur(){
        imprimer.pdfLecteur();
        
    }
    
    public void btnImprimerLivre(){
         imprimer.pdfLivre();
    }
    
    public void btnImprimerPret(){
        imprimer.pdfPret();
    }
    
    public void btnImprimerOuvrage(){
         imprimer.pdfOuvrage();
}
}
