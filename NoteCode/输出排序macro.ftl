<#--  interpret使用测试  -->
<#assign index = 0><@"<#assign arr${index}>	xxxxxxx    yyyyyyy</#assign>"?interpret />${arr0}

<#assign position = "front"/>  
<#assign order = "after"/>  
<#assign aa= "front"/>  
<#assign front="aaaa">
<#assign template>${"<#if "+aa+"=='aaaa'>+
r"${"+aa+r"}</#if>"}</#assign>
<@template?interpret />


<#--  初级版  -->
<#macro printSort position order>
  <#if position == "front">
    <#if order == "before">
       <#assign front>
         <#nested>
         <#if front??>${front}</#if><#t>
       </#assign>
    </#if>
    <#if order == "after">
       <#assign front>
         <#if front??>${front}</#if><#t>
         <#nested>
       </#assign>
    </#if>
  </#if>
  <#if position == "middle">
    <#if order == "before">
       <#assign middle>
         <#nested>
         <#if middle??>${middle}</#if><#t>
       </#assign>
    </#if>
    <#if order == "after">
       <#assign middle>
         <#if middle??>${middle}</#if><#t>
         <#nested>
       </#assign>
    </#if>
  </#if>
  <#if position == "behind">
    <#if order == "before">
       <#assign behind>
         <#nested>
         <#if behind??>${behind}</#if><#t>
       </#assign>
    </#if>
    <#if order == "after">
       <#assign behind>
         <#if behind??>${behind}</#if><#t>
         <#nested>
       </#assign>
    </#if>
  </#if>
</#macro>

<@printSort "front" "before">
111111
</@printSort>
<@printSort "front" "after">
222222
</@printSort>
<@printSort "front" "before">
33333
</@printSort>
<@printSort "middle" "before">
44444
</@printSort>
<@printSort "middle" "after">
555555
</@printSort>
<@printSort "middle" "before">
666666
</@printSort>
<@printSort "behind" "before">
777777
</@printSort>
<@printSort "behind" "after">
88888
</@printSort>
<@printSort "behind" "before">
999999
</@printSort>

${front}<#t>
${middle}<#t>
${behind}<#t>

<#--  freemarker输出排序【高级版】  -->
<#--  排序宏  -->
<#macro outputSort priority position>
  <#assign outputSort_nested><#nested></#assign>
  <#if !outputSort_maxPriority?has_content>
    <#assign outputSort_maxPriority = priority>
  <#else>
    <#if priority gt outputSort_maxPriority >
      <#assign outputSort_maxPriority = priority>
    </#if>
  </#if>
  <#assign outputSort_template>${
    "<#if position == 'before'>
      <#assign outputSort_param"+priority+">
        "+r"${outputSort_nested}<#t>"+"
        <#if outputSort_param"+priority+"?has_content>"+r"${outputSort_param"+priority+"}</#if><#t>
      </#assign>
    </#if>
    <#if position== 'after'>
      <#assign outputSort_param"+priority+">
        <#if outputSort_param"+priority+"?has_content>"+r"${outputSort_param"+priority+"}</#if><#t>
        "+r"${outputSort_nested}<#t>"+"
      </#assign>
    </#if>"
  }</#assign>
  <@outputSort_template?interpret />
</#macro>
<#--  输出宏  -->
<#macro outputSort_print>
  <#if outputSort_maxPriority?has_content && outputSort_maxPriority?is_number>
    <#list 0..outputSort_maxPriority as i >
      <#assign outputSort_template>${
        "<#if outputSort_param"+i+"?has_content>"
        +r"${outputSort_param"+i+"}<#t>"
        +"</#if>"
      }</#assign>
      <@outputSort_template?interpret />
    </#list>
  </#if>
</#macro>
<#--  重置变量  -->
<#macro outputSort_clear>
  <#if outputSort_maxPriority?has_content && outputSort_maxPriority?is_number>
    <#list 0..outputSort_maxPriority as i >
      <#assign outputSort_template>${
        "<#if outputSort_param"+i+"?has_content>"
        +r"<#assign outputSort_param"+i+r"=''/>"
        +"</#if>"
      }</#assign>
      <@outputSort_template?interpret />
    </#list>
    <#assign outputSort_maxPriority='' />
  </#if>
</#macro>
<#--  使用outputSort排序示例  -->
<@outputSort 0 "before">
111111
</@outputSort>
<@outputSort 0 "after">
222222
</@outputSort>
<@outputSort 0 "before">
33333
</@outputSort>
<@outputSort 1 "before">
44444
</@outputSort>
<@outputSort_clear />
<@outputSort 1 "after">
555555
</@outputSort>
<@outputSort 1 "before">
666666
</@outputSort>
<@outputSort 2 "before">
777777
</@outputSort>
<@outputSort 2 "after">
88888
</@outputSort>
<@outputSort 2 "before">
999999
</@outputSort>
<#--  最终使用outputSort_print输出  -->
<@outputSort_print />