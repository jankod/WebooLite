<#-- @ftlvariable name="table" type="hr.ja.weboo.ui.table.Table" -->
<table>
    <theead>
        <#list table.getColumns() as column >
            <tr>
                <th>${column.getHeader().getLabel()}</th>
            </tr>
        </#list>
    </theead>
    <tbody>
    <#list table.getData() as data>
        <tr>
            <#list  table.getColumns() as column >
                <td>${column.getRenderer().render(data)}</td>
            </#list>
        </tr>
    </#list>
    </tbody>
</table>