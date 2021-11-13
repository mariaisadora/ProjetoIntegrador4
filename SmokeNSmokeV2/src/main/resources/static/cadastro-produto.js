function addImage() {
  let url = document.getElementById('url_imagem').value;
  let lista = document.getElementById('lista-imagens');
  
  let s = `<li class="list-group-item d-flex justify-content-between align-items-center" style="overflow: auto">`
                +url+
                `<input name="imagem" type="hidden" value="` + url + `"><button type="button" class="btn btn-danger sm" onclick="$(this).closest('li').remove();">Remover</button>
              </li>`;

  lista.insertAdjacentHTML("beforeend", s);
  
  document.getElementById('url_imagem').value='';
  
}

function visualizarProduto(){
  
}