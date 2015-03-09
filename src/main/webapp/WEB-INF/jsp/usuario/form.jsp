<c:set var="activeUsuario" value="active" />

<div class="container">
	<div class="block">
	    <div class="navbar navbar-inner block-header">
	        <div class="muted pull-left"><fmt:message key = "form.usuario"/></div>
	    </div>
	    <div class="block-content collapse in">
           	<form action="<c:url value="/usuario/salvar"/>" method="post">
         	 	<input id="entidadeId" type="hidden" name="entidade.id" value="${entidade.id}" />
              <fieldset>
                <legend><fmt:message key = "usuario"></fmt:message></legend>
                <div class="control-group">
                  <label class="control-label"><fmt:message key="nome"/></label>
                  <div class="controls">
                    <input id='usuarioNome' class = "form-control" type="text" name="entidade.nome" value="${entidade.nome}"/>
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label"><fmt:message key="email"/></label>
                  <div class="controls">
                    <input id="usuarioEmail" class = "form-control" type="email" name="entidade.email" value="${entidade.email}"/>
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label"><fmt:message key="senha"/></label>
                  <div class="controls">
                    <input id="usuarioSenha" class = "form-control" type="password" name="entidade.senha" value="${entidade.senha}"/>
                  </div>
                </div>
                <div class="form-actions">
                  <button type="submit" class="btn btn-primary"><fmt:message key="save"/></button>
                  <a type="button" class="btn" href="${ctx}">Cancelar</a>
                </div>
              </fieldset>
            </form>
	    </div>
	</div>
</div>
