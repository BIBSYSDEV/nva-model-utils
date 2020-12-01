# nva-model-utils
Utilities to ease transition between different versions of NVA datamodel and publication

Tool 1) **datapielineexport-reader**; read S3 bucket with dataexport from datapipeline and write back to publication-api

Steps: 
1) **Read S3 bucket**, parameters: *S3bucketName + key*
2) Read and **split files** in S3 bucket to streams - > Stream<Publication>
3) perform **changes** to Publication -> Publication
4) **Persist** publication, either:
   * Update (PUT) publication to existing *API-endpoint*
   * Write (POST) publication to new /empty *API-endpoint*

     
  


