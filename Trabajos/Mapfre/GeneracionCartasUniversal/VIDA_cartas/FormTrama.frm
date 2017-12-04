VERSION 5.00
Object = "{F9043C88-F6F2-101A-A3C9-08002B2F49FB}#1.2#0"; "Comdlg32.ocx"
Begin VB.Form FrmRenovaciones 
   BorderStyle     =   5  'Sizable ToolWindow
   Caption         =   "Genera Data de Reporte"
   ClientHeight    =   6255
   ClientLeft      =   60
   ClientTop       =   330
   ClientWidth     =   9135
   ForeColor       =   &H80000014&
   LinkTopic       =   "Form1"
   MinButton       =   0   'False
   ScaleHeight     =   6255
   ScaleWidth      =   9135
   ShowInTaskbar   =   0   'False
   StartUpPosition =   3  'Windows Default
   WhatsThisHelp   =   -1  'True
   Begin MSComDlg.CommonDialog DlgAbrir 
      Left            =   6960
      Top             =   600
      _ExtentX        =   847
      _ExtentY        =   847
      _Version        =   393216
   End
   Begin VB.DirListBox Dir1 
      Height          =   315
      Left            =   6960
      TabIndex        =   5
      Top             =   720
      Width           =   615
   End
   Begin VB.CommandButton CmdSalr 
      Caption         =   "Salir"
      Height          =   375
      Left            =   4920
      TabIndex        =   4
      Top             =   5040
      Width           =   1455
   End
   Begin VB.CommandButton CmdAceptar 
      Caption         =   "Aceptar"
      Height          =   375
      Left            =   2280
      TabIndex        =   3
      Top             =   5040
      Width           =   1335
   End
   Begin VB.TextBox TxtSalidaDcto 
      Height          =   735
      Left            =   360
      TabIndex        =   2
      Top             =   1320
      Width           =   7215
   End
   Begin VB.TextBox TxtaBuscar 
      Height          =   375
      Left            =   360
      TabIndex        =   1
      Top             =   600
      Width           =   6255
   End
   Begin VB.TextBox Text1 
      Alignment       =   2  'Center
      BackColor       =   &H80000012&
      Enabled         =   0   'False
      ForeColor       =   &H80000018&
      Height          =   405
      Left            =   0
      TabIndex        =   0
      Top             =   5760
      Visible         =   0   'False
      Width           =   9132
   End
End
Attribute VB_Name = "FrmRenovaciones"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit

Dim CnOracle As New ADODB.Connection
Dim CnAS400  As New ADODB.Connection

Const Mensaje As String = "Carga Registro Compra/Venta Latina"
Const sisgenMaskMonto = "###,###,###,###.#0"

'variables de estructura Parametro
 Dim Operacion As String ' Operacion = I Insertar D Delete
 Dim Ambiente As String  ' Ambiente = D Desarrollo P Produccion
 
 Dim CIA As Integer
 Dim OFI As Integer
 Dim RAMO As Integer
 Dim poliza As Long
 Dim RENO As Integer
 Dim NFOR As Long
 Dim TFIA As String
 Dim CONTRA As String
 Dim AFIA  As String
 Dim FIVIG As String
 Dim FFVIG As String
 Dim IAFIA As Double
 Dim DMONE As String
 
'variables de Parametro incluido en String

Dim Ano As Integer
Dim mes As Integer
Dim textoFlagTipoComp As String
 'Param FlagTipoComp : V=Venta  C=Compra
Dim FlagTipoComp As String
 'Param FlagServidor : D=Desarrollo P=produccion
Dim FlagServidor As String
Dim gStrParametro As String
Dim Dirtexto As String, DirSalida As String, Nro_CtaPag As Integer, Nro_Pag As Integer, pepe As String
Dim Salida As String
Dim apWord As New Word.Application 'variable tipo aplicacion de Word
' para otra variable
Dim Datos(1 To 145, 1 To 3) As String, Datos_Xls As String
Public RetornoNormal As Boolean, PaseAcceso As Boolean, UsrServidor As String, UsrAcceso As String, UsrPassword As String

'definir conexion
Sub ConexionAS400()
'--------------------
   Dim strLoginId As String, strPassword As String, strServidor As String
   Dim Cadena As String

   If Ambiente = "D" Then  ' Acceso para produccion
     ' DATOS DE ACCESOS
      strLoginId = "JMANSILLA"
      strPassword = "MAXANDRE"
      strServidor = "DLATINA"
    
    Else
      
      strLoginId = "QLATKFILE"
      strPassword = "P7M1M9F6C"
      strServidor = "SULAMERI"
   End If
'
Cadena = "Provider=IBMDA400.DataSource.1;Persist Security Info=true;" & _
                                    "User ID=" & strLoginId & ";" & _
                                    "Password=" & strPassword & ";" & _
                                    "Data Source=" & strServidor & ";"
''??? CNAS400 DONDE SE DEFINE
 With CnAS400
     .CursorLocation = adUseClient
     .ConnectionString = Cadena
     .Open
 End With

End Sub
 
 'rutina xxxx Prueba
  
Sub ConexionOraclePrueba()
    Dim Cadena As String
    Dim strLoginId As String, strPassword As String, strServidor As String
    If Ambiente = "D" Then  ' Acceso para produccion
       strLoginId = UCase("CAUCION")
       strPassword = UCase("CAUCION")
       strServidor = "WEBDESA.MAPFREPERU.COM"
     Else
       strLoginId = UCase("CAUCION")
       strPassword = UCase("CAUCION")
       strServidor = "WEBPRD.MAPFREPERU.COM"  'PRODUCCION
    End If
        
    
    
On Error GoTo ErrCon
        Cadena = "Provider=MSDAORA.1;User ID=" & strLoginId & ";Data Source=" & strServidor & ";Password=" & strPassword & ";"
        With CnOracle
            .CursorLocation = adUseClient
            .ConnectionString = Cadena
            .Open
        End With
        Exit Sub
ErrCon:
    MsgBox Err.Description
End Sub
 ' fin rutina Prueba
'rutina xxxx produc
  Sub ConexionOracle()
    Dim Cadena As String
    Dim strLoginId As String, strPassword As String, strServidor As String
        
    strServidor = UCase(FrmRenovaciones.UsrServidor)
    strLoginId = UCase(FrmRenovaciones.UsrAcceso)
    strPassword = LCase(FrmRenovaciones.UsrPassword)
       
On Error GoTo ErrCon
        Cadena = "Provider=MSDAORA.1;User ID=" & strLoginId & ";Data Source=" & strServidor & ";Password=" & strPassword & ";"
        With CnOracle
            .CursorLocation = adUseClient
            .ConnectionString = Cadena
            .Open
        End With
        Exit Sub
ErrCon:
    MsgBox Err.Description
End Sub
Private Sub CmdAceptar_Click()
  If Trim(TxtaBuscar.Text) = "" Then
     MsgBox " Digite ubicación del Texto a procesar ", vbInformation, "Texto Procesar"
     Exit Sub
    Else
     
    If InStr(UCase(TxtaBuscar.Text), ".DOC") < 1 Then
      MsgBox " Documento debe ser del Tipo WORD ", vbInformation, "Tipo Documento"
      Exit Sub
    End If
  End If
  Screen.MousePointer = vbHourglass
  'Nro_Pag = Word_Txt("C:\Componentes\VIDA\Ejemplo.Doc")
  Nro_Pag = Word_Txt(TxtaBuscar.Text)
  TxtSalidaDcto = "Documento tiene " & Nro_Pag & " Páginas"
  Call Procesa_Txt(Dirtexto, Nro_Pag, App.Path & "\DESCRIPCION ESTRUCTURA CARTA.xls")
  FrmRenovaciones.Text1.Text = FrmRenovaciones.UsrAcceso + ". Se generó información del Reporte"
  Screen.MousePointer = vbArrow
  

End Sub


Private Function Word_Txt(Path_Doc As String) As Integer

On Error GoTo errSub
    'Variable de objeto para poder abrir el Word
    Dim obj_Word As Word.Application
    'Variable de tipo documento de Word
    Dim obj_Documento As Word.Document
    'Varable Enetero de Nro_pag
    Dim paginas As Integer
       
       
    'Creamos la referencia para llamar a la aplicación
    Set obj_Word = New Word.Application
        
    'Abrimos el archivo.doc que está en el app.path
    Set obj_Documento = obj_Word.Documents.Open(Path_Doc)
    ' Obtenemos saber el nro de paginas del docmto
     paginas = obj_Documento.ComputeStatistics(wdStatisticPages)
    'Copiamos el documento Word en un Texto
    With obj_Documento
        'Guardamos el contenido del .Doc en formato txt, _
         es decir solo el texto sin tablas o cualquier _
         objeto que contenga el mismo
        Dirtexto = App.Path & "\ArchivodetextoEjemplo.txt"
        ActiveDocument.SaveAs FileName:=Dirtexto, _
                                                FileFormat:=wdFormatText
        ActiveDocument.PageSetup.OtherPagesTray = wdPrinterDefaultBin
       '' wdPrinterUpperBin '- -.OtherPagesTray
             
       .SaveAs FileName:=App.Path & "\ArchivodetextoEjemplo.txt", _
                                                FileFormat:=wdFormatText
    End With
  
    'Cerramos la aplicacion
    obj_Word.Quit
    'Descargamos las variables de la memoria
    Set obj_Word = Nothing
    Set obj_Documento = Nothing
    
    Word_Txt = paginas
Exit Function
  
errSub:
  
MsgBox Err.Description, vbCritical
  
On Local Error Resume Next
  
       
    obj_Word.Quit
    Set obj_Word = Nothing
    Set obj_Documento = Nothing
    Word_Txt = 0
  
End Function

Private Sub Procesa_Txt(Dir_Doc As String, Nro_pagina As Integer, Dir_Xls As String)


On Error GoTo errSub
Dim Nro_Contador As Integer
Dim textox As String, pos_txt As Integer, nro_poliza As String
Dim texto_fijo As String, textox_2 As String, textox_fdesde As String, textox_fhasta As String, textox_2v As String, txt_XlsSheetI6 As String, renglon As String, Nro_Linea As Integer
Dim I As Integer, Pos_I As Integer, J As Integer, Pos_tabla As Integer, X_found As Boolean, Primera_vez As Boolean, X_vez As Boolean, SalLoop As Boolean
'Definicion de archivo excel
Dim txt_obviado1 As String, txt_obviado2 As String, ENCONTRADO As Integer
Dim X_fin As Boolean, X_Inicio_tabla As Boolean, X_Primer_inicio As Boolean, X_quiebre_pag As Boolean, X_Pos_Lin_tabla As Integer, Ncol_tabla As Integer, NLinea_tabla As Integer
Dim mAdo As ADODB.Recordset, mAdo1 As ADODB.Recordset, Cuenta As Long, conta As Long
Dim STRSQL As String, LibAmbiente As String
'---
Dim nro_carta_vu As Double
Dim ano_carta_vu As Double
Dim num_poliza_vu As Double
Dim fec_efectiva_vu As String
Dim f_sistema_vu As String, h_sistema_vu As String, u_sistema_vu As String
'-- variables de importe para salida a tabla
Dim v_prima_ingre, v_cargo_admin, v_costo_segu, v_interes, v_pct_interes, v_rescate As Double
Dim v_benef_muer_1, v_benef_muer_2, v_efec_acum_1, v_efec_acum_2, v_bal_acum_1, v_bal_acum_2, v_rescate_1, v_rescate_2, v_efec_resc_1, v_efec_resc_2 As Double
Dim v_postal As String

'--
    Dim xlsApp As Excel.Application
    Dim XlsBook As Workbook
    Dim XlsSheet As Worksheet
    
    
    'Screen.MousePointer = vbHourglass
    
    Set xlsApp = CreateObject("Excel.Application")
    xlsApp.Visible = False
    Set XlsBook = xlsApp.Workbooks.Open(Dir_Xls)
    Set XlsSheet = XlsBook.Worksheets(1)
'---
'renglon = Chr(13) & Chr(10)
texto_fijo = XlsSheet.Cells(2, 7)
txt_obviado1 = "Beneficio de Termino"
txt_obviado2 = "(TAP) :"
'f_sistema_vu = "20110224"
f_sistema_vu = Date$
f_sistema_vu = Right(f_sistema_vu, 4) & Left(f_sistema_vu, 2) & Mid(f_sistema_vu, 4, 2)
'h_sistema_vu = "08:00:00"
h_sistema_vu = Time$
u_sistema_vu = "PRUEBA"
              
'texto_fijo = "Reporte anual de año/aniversario" 'Ootener cabecera dcmto
Nro_Linea = 0
Nro_CtaPag = 0
Primera_vez = True
SalLoop = False
X_Inicio_tabla = False
X_quiebre_pag = False
Ncol_tabla = 8
NLinea_tabla = 13 ' nro de lineas de la tabla de Primas

'''''DirSalida = App.Path & "\TramadetextoEjemplo.txt"
'''''Open DirSalida For Output As #2
'Close #2
'Open DirSalida For Append As #2
Open Dir_Doc For Input As #1
If Not EOF(1) Then
   
   'Acceso a Oracle
    PaseAcceso = False
    RetornoNormal = True
    FlagServidor = "P" ' Flag indica  a que servidor accesará el pgm
    FrmRenovaciones.UsrServidor = "TRONPRD.MAPFREPERU.COM"
    If FlagServidor = "D" Then
       FrmRenovaciones.UsrServidor = "TRONDES.mapfreperu.com"
       FrmRenovaciones.Caption = FrmRenovaciones.Caption + " - PRUEBA"
    End If
    While Not PaseAcceso
      
      FormAcceso.Show vbModal
             
      If Not RetornoNormal Then
         PaseAcceso = True
      End If
    Wend
    
    If Not (RetornoNormal And PaseAcceso) Then
       Unload Me
        'FrmOracle.Show vbModal ' revisar
    End If
  
   ConexionOracle
   Set mAdo = New ADODB.Recordset
  
End If

u_sistema_vu = Mid(FrmRenovaciones.UsrAcceso, 1, 8)


 'Abrir excel
While Not EOF(1) And Not SalLoop     '  And Nro_CtaPag < Nro_pagina
 
  Line Input #1, pepe$
  textox = pepe$
  X_Primer_inicio = False
  If textox <> "" And Not (InStr(1, textox, txt_obviado1)) > 0 And Not (InStr(1, textox, txt_obviado2)) > 0 Then
     
     pos_txt = 1
     Nro_Linea = Nro_Linea + 1
     
     If InStr(textox, texto_fijo) > 0 Then
        ''SalLoop = False
        Pos_I = 1   'Inicializa posicion
        Nro_CtaPag = Nro_CtaPag + 1
        Nro_Linea = 1
        Datos_Xls = "" 'Limpia Cadena de Trama
        If Primera_vez Then
           Primera_vez = False
         Else
         num_poliza_vu = Val("64800" & Trim(Datos(1, 1))) '(13)
         fec_efectiva_vu = Trim(Datos(8, 1)) 'date (yyyymmdd)
         STRSQL = "select * from TRON2000.TA_VU_CARTA_ANIV_CAB  WHERE NUM_POLIZA='" & Trim(num_poliza_vu) & "'  AND FEC_EFECTIVA_VU= to_date('" & fec_efectiva_vu & "','yyyymmdd')"
         mAdo.Open STRSQL, CnOracle, adOpenForwardOnly
         If mAdo.EOF Then
           If mAdo.State = 1 Then mAdo.Close
           '
          STRSQL = "SELECT  TRON2000.SEQ_VU_CARTA_ANIVERSARIO.NEXTVAL FROM dual"
          mAdo.Open STRSQL, CnOracle, adOpenForwardOnly
          nro_carta_vu = mAdo(0) ' (7)
          ano_carta_vu = Val(Mid(Trim(Datos(8, 1)), 1, 4)) ' (4)
          'num_poliza_vu = Val("64800" & Trim(Datos(1, 1))) '(13)
          'fec_efectiva_vu = Trim(Datos(8, 1)) 'date (yyyymmdd)
          If mAdo.State = 1 Then mAdo.Close
          v_benef_muer_1 = Val(Trim(Mid(Trim(Datos(9, 1)), 2, 10) & "." & Mid(Trim(Datos(9, 1)), 12, 2)))
          v_benef_muer_2 = Val(Trim(Mid(Trim(Datos(10, 1)), 2, 10) & "." & Mid(Trim(Datos(10, 1)), 12, 2)))
          v_efec_acum_1 = Val(Trim(Mid(Trim(Datos(11, 1)), 2, 10) & "." & Mid(Trim(Datos(11, 1)), 12, 2)))
          v_efec_acum_2 = Val(Trim(Mid(Trim(Datos(12, 1)), 2, 10) & "." & Mid(Trim(Datos(12, 1)), 12, 2)))
          v_bal_acum_1 = Val(Trim(Mid(Trim(Datos(13, 1)), 2, 10) & "." & Mid(Trim(Datos(13, 1)), 12, 2)))
          v_bal_acum_2 = Val(Trim(Mid(Trim(Datos(14, 1)), 2, 10) & "." & Mid(Trim(Datos(14, 1)), 12, 2)))
          v_rescate_1 = Val(Trim(Mid(Trim(Datos(15, 1)), 2, 10) & "." & Mid(Trim(Datos(15, 1)), 12, 2)))
          v_rescate_2 = Val(Trim(Mid(Trim(Datos(16, 1)), 2, 10) & "." & Mid(Trim(Datos(16, 1)), 12, 2)))
          v_efec_resc_1 = Val(Trim(Mid(Trim(Datos(17, 1)), 2, 10) & "." & Mid(Trim(Datos(17, 1)), 12, 2)))
          v_efec_resc_2 = Val(Trim(Mid(Trim(Datos(18, 1)), 2, 10) & "." & Mid(Trim(Datos(18, 1)), 12, 2)))
          v_postal = Obt_dire_nombre(nro_poliza, LibAmbiente, "L")  'nombre postal
        '--->Graba cabecera
          STRSQL = "insert into TRON2000.TA_VU_CARTA_ANIV_CAB VALUES(" & nro_carta_vu & ", " & ano_carta_vu & ", " & num_poliza_vu & ", '" & Trim(Datos(1, 1)) & "', "
          STRSQL = STRSQL & "to_date('" & fec_efectiva_vu & "','yyyymmdd')" & ", '" & Trim(Datos(2, 1)) & "', '" & Trim(Datos(4, 1)) & "', '" & Trim(Datos(3, 1)) & "', '" & Trim(Datos(5, 1)) & "', '"
          STRSQL = STRSQL & v_postal & "' , to_date('" & Trim(Datos(7, 1)) & "','yyyymmdd') , to_date('" & Trim(Datos(8, 1)) & "','yyyymmdd'), " & v_benef_muer_1 & ", " & v_benef_muer_2
          STRSQL = STRSQL & ", " & v_efec_acum_1 & ", " & v_efec_acum_2 & ", " & v_bal_acum_1 & ", " & v_bal_acum_2
          STRSQL = STRSQL & ", " & v_rescate_1 & ", " & v_rescate_2 & ", " & v_efec_resc_1 & ", " & v_efec_resc_2
          STRSQL = STRSQL & ", to_date('" & fec_efectiva_vu & "','yyyymmdd') , '" & Trim(Datos(20, 1)) & "', null , null , to_date('" & f_sistema_vu & "','yyyymmdd')    ,'" & h_sistema_vu & "'"
          STRSQL = STRSQL & ", 'N', '" & u_sistema_vu & "', '1')"
          CnOracle.Execute STRSQL
        ' Detalle
        J = X_Pos_Lin_tabla
        For I = 1 To 12
          
          v_prima_ingre = Val(Trim(Mid(Trim(Datos(J + 1, 1)), 2, 10) & "." & Mid(Trim(Datos(J + 1, 1)), 12, 2)))
          If Mid(Trim(Datos(J + 1, 1)), 1, 1) = "-" Then
             v_prima_ingre = v_prima_ingre * -1
          End If
          v_cargo_admin = Val(Trim(Mid(Trim(Datos(J + 2, 1)), 2, 10) & "." & Mid(Trim(Datos(J + 2, 1)), 12, 2)))
          If Mid(Trim(Datos(J + 2, 1)), 1, 1) = "-" Then
             v_cargo_admin = v_cargo_admin * -1
          End If
          v_costo_segu = Val(Trim(Mid(Trim(Datos(J + 3, 1)), 2, 10) & "." & Mid(Trim(Datos(J + 3, 1)), 12, 2)))
          If Mid(Trim(Datos(J + 3, 1)), 1, 1) = "-" Then
             v_costo_segu = v_costo_segu * -1
          End If
          v_interes = Val(Trim(Mid(Trim(Datos(J + 4, 1)), 2, 10) & "." & Mid(Trim(Datos(J + 4, 1)), 12, 2)))
          If Mid(Trim(Datos(J + 4, 1)), 1, 1) = "-" Then
             v_interes = v_interes * -1
          End If
          v_pct_interes = Val(Trim(Mid(Trim(Datos(J + 5, 1)), 2, 10) & "." & Mid(Trim(Datos(J + 5, 1)), 12, 2)))
          If Mid(Trim(Datos(J + 5, 1)), 1, 1) = "-" Then
             v_pct_interes = v_pct_interes * -1
          End If
           
          v_rescate = Val(Trim(Mid(Trim(Datos(J + 6, 1)), 2, 10) & "." & Mid(Trim(Datos(J + 6, 1)), 12, 2)))
          If Mid(Trim(Datos(J + 6, 1)), 1, 1) = "-" Then
             v_rescate = v_rescate * -1
          End If
          
        '--->
          STRSQL = "insert into TRON2000.TA_VU_CARTA_ANIV_DET VALUES(" & nro_carta_vu & ", " & I & ", " & "to_date('" & Trim(Datos(J, 1)) & "','yyyymmdd') , "
          'STRSQL = STRSQL & Val(Mid(Trim(Datos(J + 1, 1)), 2, 12)) & ", " & Val(Mid(Trim(Datos(J + 2, 1)), 2, 12)) & ", " & Val(Mid(Trim(Datos(J + 3, 1)), 2, 12)) & ", " & Val(Mid(Trim(Datos(J + 4, 1)), 2, 12)) & ", "
          'STRSQL = STRSQL & Val(Mid(Trim(Datos(J + 5, 1)), 2, 12)) & ", " & Val(Mid(Trim(Datos(J + 6, 1)), 2, 12)) & ")"
          STRSQL = STRSQL & v_prima_ingre & ", " & v_cargo_admin & ", " & v_costo_segu & ", " & v_interes & ", "
          STRSQL = STRSQL & v_pct_interes & ", " & v_rescate & ")"
        
          CnOracle.Execute STRSQL
          J = J + 7
        Next I
       End If 'FIN DE VALIDA TRON2000.TA_VU_CARTA_ANIV_CAB
       If mAdo.State = 1 Then mAdo.Close
      End If
      X_quiebre_pag = False
     End If
     
     'busqueda de linea de Excel
     X_found = False
     I = Pos_I
     If X_Inicio_tabla Or X_quiebre_pag Then
       X_found = True
       I = 1
     End If
     
     While Not X_found
        I = I + 1
        If Nro_Linea = Val(Trim(XlsSheet.Cells(I, 1))) Then
           X_found = True
            Pos_I = I
         Else
          If Trim(XlsSheet.Cells(I, 1)) = "*fin" Then
             X_fin = True
             X_found = True
             SalLoop = True          ' Para forzar salida y grabar archivo
             I = 2
          End If
        End If
     Wend
   
     'Procesa la linea encontrada con estructra de Excel
     While (Nro_Linea = Val(Trim(XlsSheet.Cells(I, 1))) And I <> 0)
        If Nro_Linea = 2 Then
           ENCONTRADO = 2
        End If
        If Trim(XlsSheet.Cells(I, 3)) = "T" Then
           If Trim(XlsSheet.Cells(I, 6)) = "D" Then
           'Avance de Texto leído y  obtener la última posición de texto encontrado
             If InStr(pos_txt, textox, Trim(XlsSheet.Cells(I, 7))) > 0 Then
              pos_txt = InStr(pos_txt, textox, Trim(XlsSheet.Cells(I, 7))) + Len(Trim(XlsSheet.Cells(I, 7)))
           
             End If
            Else
             If Trim(XlsSheet.Cells(I, 6)) = "C" Then
                  X_Pos_Lin_tabla = Val(Trim(XlsSheet.Cells(I, 11)))
             End If
             
           End If
         Else
         If Trim(XlsSheet.Cells(I, 3)) = "D" Then
            If Trim(XlsSheet.Cells(I, 11)) <> "" Then
               textox_2 = Obt_Valor(textox, pos_txt, Trim(XlsSheet.Cells(I, 4)))
               pos_txt = InStr(pos_txt, textox, textox_2) + Len(textox_2)
               Select Case Trim(XlsSheet.Cells(I, 4))
                 
                 Case "N"
   
                      If Val(Trim(XlsSheet.Cells(I, 5))) > 0 Then
                         textox_2 = Forma_Importe(textox_2, Val(Trim(XlsSheet.Cells(I, 13))))
                      End If
                 Case "F"
   
                      If Nro_Linea = 2 Then
                         If Val(Trim(XlsSheet.Cells(I, 2))) = 4 Then
                            textox_fdesde = textox_2
                         End If
                         If Val(Trim(XlsSheet.Cells(I, 2))) = 6 Then
                            textox_fhasta = textox_2
                         End If
                      End If
                      textox_2 = Forma_fecha(textox_2, Trim(XlsSheet.Cells(I, 10)), Val(Trim(XlsSheet.Cells(I, 13))))
                 Case "T"
                      txt_XlsSheetI6 = XlsSheet.Cells(I, 6)
                      If Trim(XlsSheet.Cells(I, 6)) = "V" Then
                         'textox_2v = Forma_Texto(textox_2, Trim(txt_XlsSheetI6), Val(Trim(XlsSheet.Cells(I, 13))))
                         textox_2v = Obt_dire_nombre(nro_poliza, LibAmbiente, "C") 'Nombre Contrtante
                         J = Val(Trim(XlsSheet.Cells(I, 15)))
                         Datos(J, 1) = textox_2v
                         Datos(J, 2) = Val(Trim(XlsSheet.Cells(I, 12))) - Val(Trim(XlsSheet.Cells(I, 13)))
                         Datos(J, 3) = Trim(XlsSheet.Cells(I, 13))
                         txt_XlsSheetI6 = " "
                      End If
                      
                      textox_2 = Forma_Texto(textox_2, Trim(txt_XlsSheetI6), Val(Trim(XlsSheet.Cells(I, 13))))
                 
                End Select
               'Adiciona datos a arreglo
               Select Case Nro_Linea
                   Case 2 And Val(Trim(XlsSheet.Cells(I, 2))) = 2
                     'Nro Poliza formteado
                     'textox_2 = "P" & Right("0000000" & textox_2, 7)
                     textox_2 = Right("0000000" & textox_2, 8)
                     'nro_poliza = textox_2
                      nro_poliza = Trim("64800" & textox_2) '(13)
                     'num_poliza_vu = Val("64800" & Trim(Datos(1, 1))) '(13)
                   Case 7 And Val(Trim(XlsSheet.Cells(I, 2))) = 4 ' Agente
                     'Nro Poliza formteado
                     textox_2 = Space(3) & Left(XlsSheet.Cells(I, 7) + Space(Val(Trim(XlsSheet.Cells(I, 13)))), Val(Trim(XlsSheet.Cells(I, 13))))
                   Case 14 And Val(Trim(XlsSheet.Cells(I, 2))) = 1 ' Direccion
                     'Obtiene Direccion de Tablas AS/400 y Tronador
                     textox_2v = Obt_dire_nombre(nro_poliza, LibAmbiente, "D") 'Direccion contratante
                     If textox_2v <> " " Then
                        textox_2 = Forma_Texto(textox_2v, "D", 111)
                     End If
                     
               End Select
               
               If Nro_Linea = 13 Then
                 ENCONTRADO = 13
               End If
               J = Val(Trim(XlsSheet.Cells(I, 11)))
               Datos(J, 1) = textox_2
               Datos(J, 2) = Trim(XlsSheet.Cells(I, 12))
               Datos(J, 3) = Trim(XlsSheet.Cells(I, 13))
               Pos_tabla = J
               
            Else ' AVANCE EL  TEXTO
             textox_2 = Obt_Valor(textox, pos_txt, Trim(XlsSheet.Cells(I, 4)))
             pos_txt = InStr(pos_txt, textox, textox_2) + Len(textox_2)
          End If
         End If
         
        End If
       
         I = I + 1
     Wend
           
 End If
    
Wend
   If Not Primera_vez Then
       '--->comentario 'Datos = ""
       ' VALIDA SI EXISTE LA POLIZA
        num_poliza_vu = Val("64800" & Trim(Datos(1, 1))) '(13)
        fec_efectiva_vu = Trim(Datos(8, 1)) 'date (yyyymmdd)
        STRSQL = "select * from TRON2000.TA_VU_CARTA_ANIV_CAB  WHERE NUM_POLIZA='" & Trim(num_poliza_vu) & "'  AND FEC_EFECTIVA_VU= to_date('" & fec_efectiva_vu & "','yyyymmdd')"
        mAdo.Open STRSQL, CnOracle, adOpenForwardOnly
        If mAdo.EOF Then
           If mAdo.State = 1 Then mAdo.Close
       ''''------>>>>
       ' SEQUENCIA
           STRSQL = "SELECT  TRON2000.SEQ_VU_CARTA_ANIVERSARIO.NEXTVAL FROM dual"
           mAdo.Open STRSQL, CnOracle, adOpenForwardOnly
           nro_carta_vu = mAdo(0) ' (7)
           ano_carta_vu = Val(Mid(Trim(Datos(8, 1)), 1, 4)) ' (4)
           'num_poliza_vu = Val("64800" & Trim(Datos(1, 1))) '(13)
           'fec_efectiva_vu = Trim(Datos(8, 1)) 'date (yyyymmdd)
           If mAdo.State = 1 Then mAdo.Close
           v_benef_muer_1 = Val(Trim(Mid(Trim(Datos(9, 1)), 2, 10) & "." & Mid(Trim(Datos(9, 1)), 12, 2)))
           v_benef_muer_2 = Val(Trim(Mid(Trim(Datos(10, 1)), 2, 10) & "." & Mid(Trim(Datos(10, 1)), 12, 2)))
           v_efec_acum_1 = Val(Trim(Mid(Trim(Datos(11, 1)), 2, 10) & "." & Mid(Trim(Datos(11, 1)), 12, 2)))
           v_efec_acum_2 = Val(Trim(Mid(Trim(Datos(12, 1)), 2, 10) & "." & Mid(Trim(Datos(12, 1)), 12, 2)))
           v_bal_acum_1 = Val(Trim(Mid(Trim(Datos(13, 1)), 2, 10) & "." & Mid(Trim(Datos(13, 1)), 12, 2)))
           v_bal_acum_2 = Val(Trim(Mid(Trim(Datos(14, 1)), 2, 10) & "." & Mid(Trim(Datos(14, 1)), 12, 2)))
           v_rescate_1 = Val(Trim(Mid(Trim(Datos(15, 1)), 2, 10) & "." & Mid(Trim(Datos(15, 1)), 12, 2)))
           v_rescate_2 = Val(Trim(Mid(Trim(Datos(16, 1)), 2, 10) & "." & Mid(Trim(Datos(16, 1)), 12, 2)))
           v_efec_resc_1 = Val(Trim(Mid(Trim(Datos(17, 1)), 2, 10) & "." & Mid(Trim(Datos(17, 1)), 12, 2)))
           v_efec_resc_2 = Val(Trim(Mid(Trim(Datos(18, 1)), 2, 10) & "." & Mid(Trim(Datos(18, 1)), 12, 2)))
           v_postal = Obt_dire_nombre(nro_poliza, LibAmbiente, "L")  'nombre postal
        '-----> graba cabecera
          STRSQL = "insert into TRON2000.TA_VU_CARTA_ANIV_CAB VALUES(" & nro_carta_vu & ", " & ano_carta_vu & ", " & num_poliza_vu & ", '" & Trim(Datos(1, 1)) & "', "
          STRSQL = STRSQL & "to_date('" & fec_efectiva_vu & "','yyyymmdd')" & ", '" & Trim(Datos(2, 1)) & "', '" & Trim(Datos(4, 1)) & "', '" & Trim(Datos(3, 1)) & "', '" & Trim(Datos(5, 1)) & "', '"
          STRSQL = STRSQL & v_postal & "'  , to_date('" & Trim(Datos(7, 1)) & "','yyyymmdd') , to_date('" & Trim(Datos(8, 1)) & "','yyyymmdd'), " & v_benef_muer_1 & ", " & v_benef_muer_2
          STRSQL = STRSQL & ", " & v_efec_acum_1 & ", " & v_efec_acum_2 & ", " & v_bal_acum_1 & ", " & v_bal_acum_2
          STRSQL = STRSQL & ", " & v_rescate_1 & ", " & v_rescate_2 & ", " & v_efec_resc_1 & ", " & v_efec_resc_2
          STRSQL = STRSQL & ", to_date('" & fec_efectiva_vu & "','yyyymmdd') , '" & Trim(Datos(20, 1)) & "', null , null , to_date('" & f_sistema_vu & "','yyyymmdd')    ,'" & h_sistema_vu & "'"
          STRSQL = STRSQL & ", 'N', '" & u_sistema_vu & "', '1')"
          CnOracle.Execute STRSQL
        ' Detalle
          J = X_Pos_Lin_tabla
                
         For I = 1 To 12
          v_prima_ingre = Val(Trim(Mid(Trim(Datos(J + 1, 1)), 2, 10) & "." & Mid(Trim(Datos(J + 1, 1)), 12, 2)))
          If Mid(Trim(Datos(J + 1, 1)), 1, 1) = "-" Then
             v_prima_ingre = v_prima_ingre * -1
          End If
          v_cargo_admin = Val(Trim(Mid(Trim(Datos(J + 2, 1)), 2, 10) & "." & Mid(Trim(Datos(J + 2, 1)), 12, 2)))
          
          If Mid(Trim(Datos(J + 2, 1)), 1, 1) = "-" Then
             v_cargo_admin = v_cargo_admin * -1
          End If
          v_costo_segu = Val(Trim(Mid(Trim(Datos(J + 3, 1)), 2, 10) & "." & Mid(Trim(Datos(J + 3, 1)), 12, 2)))
          If Mid(Trim(Datos(J + 3, 1)), 1, 1) = "-" Then
             v_costo_segu = v_costo_segu * -1
          End If
          v_interes = Val(Trim(Mid(Trim(Datos(J + 4, 1)), 2, 10) & "." & Mid(Trim(Datos(J + 4, 1)), 12, 2)))
          If Mid(Trim(Datos(J + 4, 1)), 1, 1) = "-" Then
             v_interes = v_interes * -1
          End If
          v_pct_interes = Val(Trim(Mid(Trim(Datos(J + 5, 1)), 2, 10) & "." & Mid(Trim(Datos(J + 5, 1)), 12, 2)))
          
          If Mid(Trim(Datos(J + 5, 1)), 1, 1) = "-" Then
             v_pct_interes = v_pct_interes * -1
          End If
          v_rescate = Val(Trim(Mid(Trim(Datos(J + 6, 1)), 2, 10) & "." & Mid(Trim(Datos(J + 6, 1)), 12, 2)))
          If Mid(Trim(Datos(J + 6, 1)), 1, 1) = "-" Then
             v_rescate = v_rescate * -1
          End If
          
          
        '--->
          STRSQL = "insert into TRON2000.TA_VU_CARTA_ANIV_DET VALUES(" & nro_carta_vu & ", " & I & ", " & "to_date('" & Trim(Datos(J, 1)) & "','yyyymmdd') , "
          STRSQL = STRSQL & v_prima_ingre & ", " & v_cargo_admin & ", " & v_costo_segu & ", " & v_interes & ", "
          STRSQL = STRSQL & v_pct_interes & ", " & v_rescate & ")"
          CnOracle.Execute STRSQL
          J = J + 7
         Next I
       
      End If ' VALIDA NO EXISTA  EN TRON2000.TA_VU_CARTA_ANIV_CAB
      If mAdo.State = 1 Then mAdo.Close
   End If
 
Close #1

Exit Sub
  
errSub:
  
MsgBox Err.Description, vbCritical
  
End Sub



Private Sub CmdSalr_Click()
   Unload Me
End Sub




Private Sub Dir1_Change()
'dlgAbrir.ShowOpen
  DlgAbrir.ShowSave
  TxtaBuscar.Text = DlgAbrir.FileName
 ' If Trim(TxtaBuscar.Text) <> "" Then
 '  TxtaBuscar.Text = obtDireccion(TxtaBuscar.Text)
 ' End If
  
End Sub

 ' Carga de Programa Formulario

Private Sub Form_Load()
  '-- gStrParametro = Command()
  'gstrParametro = "D" Desarrollo "P" Produccion
  'gStrParametro = "I" Insertar   "D" Delete "X" Elimina tabla "B" Lee Tabla "C" Consulta
  'gStrParametro =
End Sub

Private Sub Form_UnloadX(Cancel As Integer)
  apWord.Documents.Close 'cerrar el documento
  Set apWord = Nothing 'quitar la referencia del objeto
End Sub

'Forma_fecha (textox_2)
Public Function Forma_fecha(ByVal txt As String, ByVal formato As String, ByVal x_len As Integer) As String
    Dim mes As String
    If formato = "SDMA" Then
       Forma_fecha = Trim(Right(txt, 4) & Mid(txt, 4, 2) & Left(txt, 2))
     Else
     If formato = "EDMA" Then
        Forma_fecha = Left(txt, 2)
        Select Case Val(Mid(txt, 4, 2))
          Case 1
             mes = " de enero de "
          Case 2
             mes = " de febrero de "
          Case 3
             mes = " de marzo de "
          Case 4
             mes = " de abril de "
          Case 5
             mes = " de mayo de "
          Case 6
             mes = " de junio de "
          Case 7
             mes = " de julio de "
          Case 8
             mes = " de agosto de "
          Case 9
             mes = " de setiembre de "
          Case 10
             mes = " de octubre de "
          Case 11
             mes = " de noviembre de "
          Case 12
             mes = " de diciembre de "
        End Select
        Forma_fecha = Left(Trim(Right("00" + Forma_fecha, 2)) + mes + Right(txt, 4) + Space(x_len), x_len)
     End If
    End If
     
End Function

Public Function Obt_dire_nombre(ByVal poliza As String, ByVal lib As String, ByVal Tdato As String) As String
'On Error GoTo errSubSql
 Dim STRSQL As String, Flg_Tronador As Boolean, TDocu As String, NroDocu As String
 Dim mAdo As ADODB.Recordset, mAdo2 As ADODB.Recordset, Cuenta As Long, conta As Long
 Set mAdo = New ADODB.Recordset
 Set mAdo2 = New ADODB.Recordset

 STRSQL = "SELECT  A.TIP_DOCUM, A.COD_DOCUM  FROM  "
 STRSQL = STRSQL & " A2000030 A  WHERE A.COD_CIA = 02 AND A.NUM_POLIZA = '" & poliza & "'"        'poliza ejemplo: P3600264
 
  
 'mAdo.Open STRSQL, CnAS400, adOpenForwardOnly
 mAdo.Open STRSQL, CnOracle, adOpenForwardOnly
 Flg_Tronador = False
 Obt_dire_nombre = " "
 
  If Not (mAdo.EOF) Then
   'Obt_direccion = mAdo(0)   SE COMENTA
   NroDocu = Trim(mAdo(1))
   TDocu = Trim(mAdo(0))
   If Tdato = "D" Then
     STRSQL = "select NOM_DOMICILIO1, NOM_DOMICILIO2, NOM_DOMICILIO3 from a1001331 where cod_cia=02 and  cod_docum='" & NroDocu & "'  AND tip_docum='" & TDocu & "'"
     mAdo2.Open STRSQL, CnOracle, adOpenForwardOnly
     If Not (mAdo2.EOF) Then
       Obt_dire_nombre = Trim(mAdo2(0) & " " & mAdo2(1) & " " & mAdo2(2))
     End If
   Else
    If Tdato = "L" Then
        STRSQL = "select NVL(nom_localidad,'SIN DISTRITO') from a1001331 where cod_cia=02 and  cod_docum='" & NroDocu & "'  AND tip_docum='" & TDocu & "'"
        mAdo2.Open STRSQL, CnOracle, adOpenForwardOnly
       If Not (mAdo2.EOF) Then
          Obt_dire_nombre = Trim(mAdo2(0))
        Else
          If mAdo2.State = 1 Then mAdo2.Close
          STRSQL = "select NVL(nom_localidad,'SIN DISTRITO') from a1001332 a where a.cod_cia=02 and  a.cod_docum='" & NroDocu & "'  AND a.tip_docum='" & TDocu & "'"
          STRSQL = STRSQL & " AND A.FEC_VALIDEZ = (SELECT MAX(B.FEC_VALIDEZ) FROM A1001332 B Where B.cod_cia =" & 2 & " AND B.tip_docum ='" & TDocu & "' "
          STRSQL = STRSQL & " AND B.cod_docum ='" & NroDocu & "' AND B.cod_act_tercero = 1 )"
          mAdo2.Open STRSQL, CnOracle, adOpenForwardOnly
          If Not (mAdo2.EOF) Then
             Obt_dire_nombre = Trim(mAdo2(0))
           Else
            If mAdo2.State = 1 Then mAdo2.Close
            STRSQL = "select NVL(nom_localidad,'SIN DISTRITO') from a1001300 a where a.cod_cia=02 and  a.cod_docum='" & NroDocu & "'  AND a.tip_docum='" & TDocu & "'"
            STRSQL = STRSQL & " AND A.FEC_VALIDEZ = (SELECT MAX(B.FEC_VALIDEZ) FROM A1001300 B Where B.cod_cia =" & 2 & " AND B.tip_docum ='" & TDocu & "' "
            STRSQL = STRSQL & " AND B.cod_docum ='" & NroDocu & "' AND B.cod_act_tercero = 1 )"
            mAdo2.Open STRSQL, CnOracle, adOpenForwardOnly
            If Not (mAdo2.EOF) Then
               Obt_dire_nombre = Trim(mAdo2(0))
            End If
          End If
       End If
    
     Else
     STRSQL = "select APE1_TERCERO, APE2_TERCERO, NOM_TERCERO from a1001399 where cod_cia=02 and  cod_docum='" & NroDocu & "'  AND tip_docum='" & TDocu & "'"
     mAdo2.Open STRSQL, CnOracle, adOpenForwardOnly
     If Not (mAdo2.EOF) Then
       Obt_dire_nombre = Trim(mAdo2(0) & " " & mAdo2(1) & ", " & mAdo2(2))
     End If
    End If
   End If
  
  End If
  If mAdo2.State = 1 Then mAdo2.Close
  If mAdo.State = 1 Then mAdo.Close
        
End Function
Public Function Forma_Importe(ByVal txt As String, ByVal tamaño As Integer) As String
    Dim I As Integer, J As Integer, txt_sal As String, txt_sIGNO As String
    txt_sal = ""
    txt_sIGNO = "+"
    For I = 1 To Trim(Len(txt))
       If (Mid(txt, I, 1) <> "," And Mid(txt, I, 1) <> ".") Then
          If Mid(txt, I, 1) = "-" Then
             txt_sIGNO = "-"
            Else
           txt_sal = txt_sal + Mid(txt, I, 1)
          End If
       End If
    Next I
    'Forma_Importe = "+" + Trim(Right("000000000000" & txt_sal, tamaño - 1))
     Forma_Importe = Trim(txt_sIGNO + Trim(Right("000000000000" & txt_sal, tamaño - 1)))
         
End Function


Public Function Forma_Texto(ByVal txt As String, ByVal tipo As String, ByVal tamaño As Integer) As String
    Dim I As Integer, J As Integer, txt_sal As String, blanco As String
    txt_sal = Trim(txt)
    Forma_Texto = ""
    blanco = ""
    If tipo <> "V" Then
       If tipo <> "R" Then
          Forma_Texto = Left(txt_sal + Space(tamaño), tamaño)
        Else
          Forma_Texto = Right(Space(tamaño) + txt_sal + Space(1), tamaño)
       End If
     
     Else
      'Apellidos
      J = 0
      For I = Len(txt_sal) To 1 Step -1
           
           If Mid(txt_sal, I, 1) = " " Then
              If blanco <> Mid(txt_sal, I, 1) Then
                 blanco = Mid(txt_sal, I, 1)
                 J = J + 1
              End If
            Else
             If blanco = " " Then
                blanco = ""
             End If
           End If
           
           
           If J < 2 Then
              Forma_Texto = Mid(txt_sal, I, 1) + Forma_Texto
            Else
             For J = (I + 1) To 1 Step -1
               If (Mid(txt_sal, J, 1) <> " " And Mid(txt_sal, J, 1) <> ",") Then
                 Exit For
               End If
             Next J
             Exit For
           End If
       Next I
       Forma_Texto = Left(Forma_Texto + ", " + Mid(txt_sal, 1, Len(txt_sal) - J + 1) + Space(tamaño), tamaño)
    End If
End Function


Public Function Obt_Valor(ByVal txt_text As String, ByVal txt_pos As Integer, ByVal txt_tval As String) As String
     Dim I As Integer, J As Integer
     Dim DiRastreo As String
     Obt_Valor = ""
     'DiRastreo = App.Path & "\RastreotextoEjemplo.txt"
     If txt_tval <> "T" Then
        For I = txt_pos To Len(txt_text)
          If (Asc(Mid(txt_text, I, 1)) <> 9 And Asc(Mid(txt_text, I, 1)) <> 32) Then
            'Open DiRastreo For Append As #3
            J = I
            Do While (Asc(Mid(txt_text, J, 1)) <> 9 And Asc(Mid(txt_text, J, 1)) <> 32)
            'Write #3, Mid(txt_text, j, 1), Asc(Mid(txt_text, j, 1))
               J = J + 1
               If J > Len(txt_text) Then
                Exit Do
               End If
            Loop
            'Close #3
            J = J - I
           Obt_Valor = Trim(Mid(txt_text, I, J))
           I = Len(txt_text) + 1
         End If
       Next I
      Else
       J = txt_pos
       Do While (Asc(Mid(txt_text, J, 1)) = 9 Or Asc(Mid(txt_text, J, 1)) = 32)
          J = J + 1
       Loop
       'Obt_Valor = Mid(txt_text, J, Len(txt_text) - J + 1)
       For I = J To Len(txt_text)
            If (Asc(Mid(txt_text, I, 1)) <> 9) Then
                Obt_Valor = Obt_Valor + Mid(txt_text, I, 1)
             Else
               Exit For
            End If
       Next I
     End If
     
     
End Function
Public Function Apostrofe(ByVal strCadena As String) As String
  Dim I As Integer, strConcatenar As String, strResultado As String
  strCadena = Trim(strCadena)
  strResultado = ""
  For I = 1 To Len(strCadena)
      If Mid(strCadena, I, 1) = "'" Then
         strConcatenar = "''"
      Else
         strConcatenar = Mid(strCadena, I, 1)
      End If
      strResultado = strResultado + strConcatenar
  Next I
  Apostrofe = UCase(strResultado)
End Function

