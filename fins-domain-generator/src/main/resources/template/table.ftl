package com.next.fins.domain.entity;
//import java.time.LocalDate;
import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;

import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonBackReference;

<#assign Util=statics['com.sap.b1.wcli.core.data.xml.util.Util']>
<#assign TableUtil=statics['com.sap.b1.wcli.core.data.xml.util.TableUtil']>
@SuppressWarnings("unused")
<#if TableUtil.isTable(data)>
@Entity(name="${data.id}")
</#if>
public class Bmo${data.id}
{
	<#list data.column as col>
   	<#assign upperName=col.id?cap_first>
   	<#assign lowerName=Util.decapitalize(col.id)>
   	<#assign dataType=Util.convertDbType(col.dbType)>
   	<#if TableUtil.isIdColumn(data, col)>
   	@Id
   	</#if>
   	@Column(name="\"${col.id}\"")
   	protected ${dataType} ${lowerName};
	@JsonProperty("${col.id}")
	public ${dataType} get${upperName}() {return this.${lowerName};}
	@JsonProperty("${col.id}")
	public void set${upperName}(${dataType} value) {this.${lowerName} = value;}

	<#if col.linkTo??>
   	@ManyToOne(fetch=FetchType.LAZY)
   	@JoinColumn(name="${lowerName}",insertable=false, updatable=false)
	Bmo${col.linkTo} ${lowerName}Object;
	public Bmo${col.linkTo} get${upperName}Object() {return this.${lowerName}Object;}
	</#if>

    </#list>

    <#list data.arrayTable as arrayTable>
    <#assign upperName=arrayTable?cap_first>
    <#assign lowerName=Util.decapitalize(arrayTable)>
    <#assign dataType='List<Bmo'+arrayTable+'>'>

    @OneToMany(mappedBy="parentObject")
    protected ${dataType} ${lowerName};
    @JsonProperty("${arrayTable}")
    public ${dataType} get${upperName}() {
        if(this.${lowerName}==null){
            this.${lowerName} = new ArrayList<>();
        }
        return this.${lowerName};
    }
    @JsonProperty("${arrayTable}")
    public void set${upperName}(${dataType} value) {this.${lowerName} = value;}

    </#list>

    <#if data.parentTable??>

    <#assign dataType='Bmo'+data.parentTable>
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"ParentId\"",insertable=false, updatable=false)
    @JsonBackReference
    ${dataType} parentObject;
    public ${dataType} getParentObject() {
        return parentObject;
    }
    </#if>
}