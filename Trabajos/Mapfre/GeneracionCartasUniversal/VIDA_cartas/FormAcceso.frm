VERSION 5.00
Object = "{67397AA1-7FB1-11D0-B148-00A0C922E820}#6.0#0"; "MSADODC.OCX"
Begin VB.Form FormAcceso 
   Caption         =   "Acceso a Tronador"
   ClientHeight    =   1920
   ClientLeft      =   45
   ClientTop       =   330
   ClientWidth     =   3975
   LinkTopic       =   "Form1"
   ScaleHeight     =   1920
   ScaleWidth      =   3975
   StartUpPosition =   3  'Windows Default
   Begin MSAdodcLib.Adodc Adodc1 
      Height          =   375
      Left            =   3960
      Top             =   1440
      Width           =   1200
      _ExtentX        =   2117
      _ExtentY        =   661
      ConnectMode     =   0
      CursorLocation  =   3
      IsolationLevel  =   -1
      ConnectionTimeout=   15
      CommandTimeout  =   30
      CursorType      =   3
      LockType        =   3
      CommandType     =   8
      CursorOptions   =   0
      CacheSize       =   50
      MaxRecords      =   0
      BOFAction       =   0
      EOFAction       =   0
      ConnectStringType=   1
      Appearance      =   1
      BackColor       =   -2147483643
      ForeColor       =   -2147483640
      Orientation     =   0
      Enabled         =   -1
      Connect         =   "Provider=MSDAORA.1;Persist Security Info=False"
      OLEDBString     =   "Provider=MSDAORA.1;Persist Security Info=False"
      OLEDBFile       =   ""
      DataSourceName  =   ""
      OtherAttributes =   ""
      UserName        =   ""
      Password        =   ""
      RecordSource    =   ""
      Caption         =   "Adodc1"
      BeginProperty Font {0BE35203-8F91-11CE-9DE3-00AA004BB851} 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      _Version        =   393216
   End
   Begin VB.CommandButton cmdAcceso 
      Caption         =   "CONFIRMA"
      Height          =   252
      Left            =   1080
      TabIndex        =   4
      Top             =   1560
      Width           =   1332
   End
   Begin VB.TextBox txtPassword 
      Height          =   288
      IMEMode         =   3  'DISABLE
      Left            =   1560
      PasswordChar    =   "*"
      TabIndex        =   3
      Top             =   960
      Width           =   1812
   End
   Begin VB.TextBox txtUsuario 
      Height          =   288
      Left            =   1560
      TabIndex        =   1
      Top             =   360
      Width           =   1812
   End
   Begin VB.Label lblPassword 
      Caption         =   "PASSWORD"
      Height          =   252
      Left            =   240
      TabIndex        =   2
      Top             =   960
      Width           =   972
   End
   Begin VB.Label Label1 
      Caption         =   "USUARIO "
      ForeColor       =   &H80000015&
      Height          =   252
      Left            =   240
      TabIndex        =   0
      Top             =   360
      Width           =   972
   End
End
Attribute VB_Name = "FormAcceso"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim CnOracle As New ADODB.Connection
Private Declare Function GetUserName Lib "advapi32.dll" Alias "GetUserNameA" (ByVal lpBuffer As String, nSize As Long) As Long
Dim strBuffer As String * 256


Private Sub cmdAcceso_Click()
         FrmRenovaciones.PaseAcceso = False
         If txtUsuario = "" Then
            MsgBox Left(strBuffer, 8) + ", Ingrese su Usuario  ", vbInformation, "USUARIO"
            Exit Sub
         End If
         If txtPassword = "" Then
            MsgBox Left(strBuffer, 8) + ", Ingrese su Password ", vbInformation, "PASSWORD"
            Exit Sub
         End If
         'MsgBox " PASO 1 ", vbInformation, "SEGUIMIENTO"
         txtUsuario = UCase(txtUsuario)
         txtPassword = UCase(txtPassword)
         FrmRenovaciones.UsrAcceso = txtUsuario
         FrmRenovaciones.UsrPassword = txtPassword
         
         ConexionOracle
         MsgBox " PASO CHEQUEA Y ABRE CONEXION ", vbInformation, "SEGUIMIENTO"
         CnOracle.Close
         ' MsgBox " PASO CIERRE CONEXION ", vbInformation, "SEGUIMIENTO"
         'salida de pantalla
         FrmRenovaciones.RetornoNormal = True
         Unload Me
         
End Sub

Sub ConexionOracle()
    Dim Cadena As String
    Dim strLoginId As String, strPassword As String, strServidor As String
        
    'Acceso a Produccion
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
        FrmRenovaciones.PaseAcceso = True
        Exit Sub
ErrCon:
    'MsgBox Err.Description
     MsgBox Left(strBuffer, 8) + ", Ingrese su Usuario ó password correcto  ", vbInformation, "Conexión"
End Sub

Private Sub Form_Load()
    FrmRenovaciones.RetornoNormal = False
    
    'FormAcceso.Show vbModal
    
End Sub

Private Sub Form_Unload(Cancel As Integer)
   Unload Me
End Sub

