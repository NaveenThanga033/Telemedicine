<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
  <xsl:output method="html" indent="yes"/>

  <xsl:template match="/">
    <html lang="en">
    <head>
      <meta charset="UTF-8"/>
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      <title>GenMedz Blog</title>
      <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f4; }
        nav { background-color: #74C0FC; padding: 10px; }
        nav ul { list-style: none; padding: 0; display: flex; justify-content: space-around; }
        nav ul li { display: inline; }
        nav ul li a { color: white; text-decoration: none; }
        h1 { text-align: center; }
        .blog-sec { display: flex; flex-wrap: wrap; justify-content: space-around; margin: 20px; }
        .post { width: 45%; background-color: white; padding: 20px; margin: 10px; box-shadow: 0px 0px 10px rgba(0,0,0,0.1); }
        .post h2 { color: #333; }
        .post p { line-height: 1.6; color: #666; }
      </style>
    </head>
    <body>

      <!-- Navigation -->
      

      <!-- Blog Posts -->
      <section class="blog-sec">
        <xsl:for-each select="blog/post">
          <div class="post">
            <h2><xsl:value-of select="title"/></h2>
            <p><xsl:value-of select="content"/></p>
          </div>
        </xsl:for-each>
      </section>
    </body>
    </html>
  </xsl:template>

</xsl:stylesheet>
