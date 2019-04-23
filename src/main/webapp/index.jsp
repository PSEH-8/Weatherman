<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<title>Yours everloving Weatherman</title>
<h2>Your Weatherman</h2>
<!--a href="v1/weather">Weather</a-->
<select id="dropdown"></select>
<br>
<br>
<button id="data" onclick="getWeather($('#dropdown').val())">Submit</button>
<br>
<br>
<div id="result"/>
</body>
</html>
<script>
var helpers =
{
    buildDropdown: function(result, dropdown, emptyMessage)
    {
        dropdown.html('');
        dropdown.append('<option value="">' + emptyMessage + '</option>');
        if(result != '')
        {
            $.each(result, function(k, v) {
                dropdown.append('<option value="' + v.id + '">' + v.id + '-' + v.name + '</option>');
            });
        }
    }
}

$.ajax({
            type: "GET",
            url: "v1/city",
            success: function(data)
            {
                helpers.buildDropdown(
                    data,
                    $('#dropdown'),
                    'Select an option'
                );
            }
        });


function getWeather(city){
   console.log("City: " + city);
   $.get("v1/weather?cityId="+city, function(data){
        if(data){
            $('#result').text(data);
        }else{
            $('#result').text("Problem with data");
        }

   });
}
</script>
