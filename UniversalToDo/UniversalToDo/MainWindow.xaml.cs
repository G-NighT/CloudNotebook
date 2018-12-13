using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Collections.Specialized;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System.Net.Http;
using xNet;

namespace UniversalToDo
{
    /// <summary>
    /// Логика взаимодействия для MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        WebClient client = new WebClient();

        public MainWindow()
        {
            InitializeComponent();
        }

        class MyClass
        {
            public notedata[] Notes { get; set; }
        }

        public class notedata
        {
            public int id { get; set; }
            public string note { get; set; }
            public string description { get; set; }
            public string datetime { get; set; }
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            NameValueCollection Info = new NameValueCollection();
            Info.Add("note", note.Text);
            Info.Add("description", desc.Text);
            Info.Add("datetime", DateTime.Now.ToString());
            byte[] Insert = client.UploadValues("http://mzpsib.ru/php/insertNote.php", "POST",Info);
            Button_Click_2(sender, e);
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            NameValueCollection del = new NameValueCollection();
            del.Add("id", id.Text);
            byte[] Delete = client.UploadValues("http://mzpsib.ru/php/deleteNote.php", "POST", del);
            Button_Click_2(sender,e);
        }

        private void Button_Click_2(object sender, RoutedEventArgs e)
        {
            using (var client = new System.Net.WebClient())
            {
                res.Text = client.DownloadString("http://mzpsib.ru/php/showNotesWin.php");
            }

            MyClass newClass = JsonConvert.DeserializeObject<MyClass>(res.Text);
            res.Text = "Всего заметок: " + newClass.Notes.Length + Environment.NewLine;
            foreach (var note in newClass.Notes)
            {
                res.Text += note.id + " : " + note.note + " - " + note.description + " | " + note.datetime + Environment.NewLine;
            }
        }
    }
}
