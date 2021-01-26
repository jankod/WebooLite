@import hr.ja.demo.User
@param User user

<html>
<body>

<div>Ovo je pero nije bas ${user.getName()}</div>


<b>radi nesto</b>
${user.radiNesto()}

@if(user.getName() != null)
    <p>pero</p>
@endif
<p>Opet: </p>
$unsafe{user.opet()}

<script>
    function delaj() {
        document.getElementById("pero").innerHTML = "sfsdf";
    }
</script>
</body>
</html>
