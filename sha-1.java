import java.security.*;
public class SHA1
{
public static void main(String[] a)
{
try
{
MessageDigest md = MessageDigest.getInstance(&quot;SHA1&quot;);
System.out.println(&quot;Message digest object info: &quot;);
System.out.println(&quot; Algorithm = &quot; +md.getAlgorithm());
System.out.println(&quot; Provider = &quot; +md.getProvider());
System.out.println(&quot; ToString = &quot; +md.toString());
String input = &quot;&quot;;
md.update(input.getBytes());
byte[] output = md.digest();
System.out.println();
System.out.println(&quot;SHA1(\&quot;&quot;+input+&quot;\&quot;) = &quot; +bytesToHex(output));
input = &quot;abc&quot;;
md.update(input.getBytes());
output = md.digest();
System.out.println();
System.out.println(&quot;SHA1(\&quot;&quot;+input+&quot;\&quot;) = &quot; +bytesToHex(output));
input = &quot;abcdefghijklmnopqrstuvwxyz&quot;;
md.update(input.getBytes());
output = md.digest();
System.out.println();
System.out.println(&quot;SHA1(\&quot;&quot; +input+&quot;\&quot;) = &quot; +bytesToHex(output));
System.out.println(&quot;&quot;);
}
catch (Exception e)
{
System.out.println(&quot;Exception: &quot; +e);
}
}
public static String bytesToHex(byte[] b)
{

CS6711-Security Laboratory Department of CSE 2016-2017

St.Joseph’s Institute of Technology 19
char hexDigit[] = {&#39;0&#39;, &#39;1&#39;, &#39;2&#39;, &#39;3&#39;, &#39;4&#39;, &#39;5&#39;, &#39;6&#39;, &#39;7&#39;, &#39;8&#39;, &#39;9&#39;, &#39;A&#39;, &#39;B&#39;, &#39;C&#39;, &#39;D&#39;, &#39;E&#39;, &#39;F&#39;};
StringBuffer buf = new StringBuffer();
for (int j=0; j&lt;b.length; j++)
{
buf.append(hexDigit[(b[j] &gt;&gt; 4) &amp; 0x0f]);
buf.append(hexDigit[b[j] &amp; 0x0f]);
}
return buf.toString(); }
}