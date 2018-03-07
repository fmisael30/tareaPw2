<!DOCTYPE html>
<html>
     <#include "./header.ftl">
<body>
  <#if user??>
     <h1>${user.getNombre()} ${user.getApellido()}</h1>
   <#else>
        <p> no hay usuario </p>
    </#if>
        <a href="/home"> Home </a>
  </body>
</html>