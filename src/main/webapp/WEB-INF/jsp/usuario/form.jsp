<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="container">
	<div class="block">
		<div class="navbar navbar-inner block-header">
			<div class="muted pull-left">
				<fmt:message key="form.usuario" />
			</div>
		</div>
		
		<div class="block-content collapse in">
			<form action="<c:url value="/usuario/salvar"/>" method="post">
				<input id="entidadeId" type="hidden" name = "entidade.id" value="${entidade.id}"/>
				
				<c:import url="${ctx}/template/mensagens.jsp" />
				
				<fieldset>
					<legend>
						<fmt:message key="usuario"></fmt:message>
					</legend>
					<div class="control-group">
						<label class="control-label"><fmt:message key="nome" /></label>
						<div class="controls">
							<input id='usuarioNome' class="form-control" type="text" name = "entidade.nome" value="${entidade.nome}"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label"><fmt:message key="email" /></label>
						<div class="controls">
							<input id="usuarioEmail" class="form-control" type="email" name = "entidade.email" value="${entidade.email}"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label"><fmt:message key="senha" /></label>
						<div class="controls">
							<input id="usuarioSenha" class="form-control" type="password" name = "entidade.senha"/>
						</div>
					</div>
					<div class="form-actions">
						<button type="submit" class="btn btn-primary">
							<fmt:message key="save" />
						</button>
						<a type="button" class="btn" href="<c:url value="/"/>">Cancelar</a>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	
	<div class="block">
		<div class="navbar navbar-inner block-header">
			<div class="muted pull-left"><fmt:message key = "list.usuario"></fmt:message></div>
		</div>
		<div class="block-content collapse in">
			<div class="span12">
				<table class="table table-striped">
					<thead>
						<tr>
							<th><fmt:message key = "nome"></fmt:message></th>
							<th><fmt:message key = "email"></fmt:message></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="usuario" items="${entidades}">
							<tr>
								<td>${usuario.nome}</td>
								<td>${usuario.email}</td>
								<td><a href = "<c:url value="/usuario/form/${usuario.id}"/>"><i class = "icon-edit"></i></a></td>
								<td><a href = "<c:url value="/usuario/remover/${usuario.id}"/>"><i class = "icon-trash"></i></a></td>
							</tr>
						</c:forEach>
						<c:if test="${entidades.isEmpty()}">
							<tr>
								<td><fmt:message key = "lista.vazia"></fmt:message></td>
								<td></td>
								<td></td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
