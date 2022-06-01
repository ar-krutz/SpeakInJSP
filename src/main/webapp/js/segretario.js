function edit_row(no)
{
 document.getElementById("edit_button"+no).style.display="none";
 document.getElementById("save_button"+no).style.display="block";
	
 var nome=document.getElementById("nome_row"+no);
 var cognome=document.getElementById("cognome_row"+no);
 var datanascita=document.getElementById("datanascita_row"+no);
 var codicefiscale=document.getElementById("codicefiscale_row"+no);
 var indirizzo=document.getElementById("indirizzo_row"+no);
 var email=document.getElementById("email_row"+no);
 var telefono=document.getElementById("telefono_row"+no);
 var stipendio=document.getElementById("stipendio_row"+no);
 var lingua=document.getElementById("lingua_row"+no);
 var descrizione=document.getElementById("descrizione_row"+no);
 var password=document.getElementById("password_row"+no);
	
 var nome_data=nome.innerHTML;
 var cognome_data=cognome.innerHTML;
 var datanascita_data=datanascita.innerHTML;
 var codicefiscale_data=codicefiscale.innerHTML;
 var indirizzo_data=indirizzo.innerHTML;
 var email_data=email.innerHTML;
 var telefono_data=telefono.innerHTML;
 var stipendio_data=stipendio.innerHTML;
 var lingua_data=lingua.innerHTML;
 var descrizione_data=descrizione.innerHTML;
 var password_data=password.innerHTML;
	
 nome.innerHTML="<input type='text' id='nome_text"+no+"' value='"+nome_data+"'>";
 cognome.innerHTML="<input type='text' id='cognome_text"+no+"' value='"+cognome_data+"'>";
 datanascita.innerHTML="<input type='text' id='datanascita_text"+no+"' value='"+datanascita_data+"'>";
 codicefiscale.innerHTML="<input type='text' id='codicefiscale_text"+no+"' value='"+codicefiscale_data+"'>";
 indirizzo.innerHTML="<input type='text' id='indirizzo_text"+no+"' value='"+indirizzo_data+"'>";
 email.innerHTML="<input type='text' id='email_text"+no+"' value='"+email_data+"'>";
 telefono.innerHTML="<input type='text' id='telefono_text"+no+"' value='"+telefono_data+"'>";
 stipendio.innerHTML="<input type='text' id='stipendio_text"+no+"' value='"+stipendio_data+"'>";
 lingua.innerHTML="<input type='text' id='lingua_text"+no+"' value='"+lingua_data+"'>";
 descrizione.innerHTML="<input type='text' id='descrizione_text"+no+"' value='"+descrizione_data+"'>";
 password.innerHTML="<input type='text' id='password_text"+no+"' value='"+password_data+"'>";
 
}

function save_row(no)
{
 var nome_val=document.getElementById("nome_text"+no).value;
 var cognome_val=document.getElementById("cognome_text"+no).value;
 var datanascita_val=document.getElementById("datanascita_text"+no).value;
 var codicefiscale_val=document.getElementById("codicefiscale_text"+no).value;
 var indirizzo_val=document.getElementById("indirizzo_text"+no).value;
 var email_val=document.getElementById("email_text"+no).value;
 var telefono_val=document.getElementById("telefono_text"+no).value;
 var stipendio_val=document.getElementById("stipendio_text"+no).value;
 var lingua_val=document.getElementById("lingua_text"+no).value;
 var descrizione_val=document.getElementById("descrizione_text"+no).value;
 var password_val=document.getElementById("password_text"+no).value;

 document.getElementById("nome_row"+no).innerHTML=nome_val;
 document.getElementById("cognome_row"+no).innerHTML=cognome_val;
 document.getElementById("datanascita_row"+no).innerHTML=datanascita_val;
 document.getElementById("codicefiscale_row"+no).innerHTML=codicefiscale_val;
 document.getElementById("indirizzo_row"+no).innerHTML=indirizzo_val;
 document.getElementById("email_row"+no).innerHTML=email_val;
 document.getElementById("telefono_row"+no).innerHTML=telefono_val;
 document.getElementById("stipendio_row"+no).innerHTML=stipendio_val;
 document.getElementById("lingua_row"+no).innerHTML=lingua_val;
 document.getElementById("descrizione_row"+no).innerHTML=descrizione_val;
 document.getElementById("password_row"+no).innerHTML=password_val;

 document.getElementById("edit_button"+no).style.display="block";
 document.getElementById("save_button"+no).style.display="none";
}

function delete_row(no)
{
 document.getElementById("row"+no+"").outerHTML="";
}

function add_row()
{
 var new_nome=document.getElementById("new_nome").value;
 var new_cognome=document.getElementById("new_cognome").value;
 var new_datanascita=document.getElementById("new_datanascita").value;
 var new_codicefiscale=document.getElementById("new_codicefiscale").value;
 var new_indirizzo=document.getElementById("new_indirizzo").value;
 var new_email=document.getElementById("new_email").value;
 var new_telefono=document.getElementById("new_telefono").value;
 var new_stipendio=document.getElementById("new_stipendio").value;
 var new_lingua=document.getElementById("new_lingua").value;
 var new_descrizione=document.getElementById("new_descrizione").value;
 var new_password=document.getElementById("new_password").value;
	
 var table=document.getElementById("data_table");
 var table_len=(table.rows.length)-1;
 var row = table.insertRow(table_len).outerHTML="<tr id='row"+table_len+"'><td id='nome_row"+table_len+"'>"+new_nome+"</td><td id='cognome_row"+table_len+"'>"+new_cognome+"</td><td id='datanascita_row"+table_len+"'>"+new_datanascita+"</td><td id='codicefiscale_row"+table_len+"'>"+new_codicefiscale+"</td><td id='indirizzo_row"+table_len+"'>"+new_indirizzo+"</td><td id='email_row"+table_len+"'>"+new_email+"</td><td id='telefono_row"+table_len+"'>"+new_telefono+"</td><td id='stipendio_row"+table_len+"'>"+new_stipendio+"</td><td id='lingua_row"+table_len+"'>"+new_lingua+"</td><td id='descrizione_row"+table_len+"'>"+new_descrizione+"</td><td id='password_row"+table_len+"'>"+new_password+"</td><td><input type='button' id='edit_button"+table_len+"' value='Edit' class='edit' onclick='edit_row("+table_len+")'> <input type='button' id='save_button"+table_len+"' value='Save' class='save' onclick='save_row("+table_len+")'> <input type='button' value='Delete' class='delete' onclick='delete_row("+table_len+")'></td></tr>";

 document.getElementById("new_nome").value="";
 document.getElementById("new_cognome").value="";
 document.getElementById("new_datanascita").value="";
 document.getElementById("new_codicefiscale").value="";
 document.getElementById("new_indirizzo").value="";
 document.getElementById("new_email").value="";
 document.getElementById("new_telefono").value="";
 document.getElementById("new_stipendio").value="";
 document.getElementById("new_lingua").value="";
 document.getElementById("new_descrizione").value="";
 document.getElementById("new_password").value="";
 
}