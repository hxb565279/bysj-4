import numpy as np  #导入必要的库函数
import pandas as pd
import matplotlib
import matplotlib.pyplot as plt
from matplotlib.ticker import MaxNLocator
import requests
import json
from pyecharts.charts import Map, Geo
from PIL import Image
url1 = "https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5"
url2 = "https://view.inews.qq.com/g2/getOnsInfo?name=disease_other"
url3 = "https://view.inews.qq.com/g2/getOnsInfo?name=disease_foreign"
url4 = "https://api.inews.qq.com/newsqa/v1/automation/foreign/daily/list?country=美国"

resp=requests.get(url1)
listData=[]
listData=resp.json()
listData1=json.loads(listData['data']) #把'data'转换成字典类型方便分析

#从文件中读取中国疫情的整体情况
listTime=listData1['lastUpdateTime']
pd_china=pd.DataFrame()
pd1=pd.DataFrame(listData1['chinaTotal'],index=['chinaTotal'], columns=['confirm', 'heal','dead','suspect','nowConfirm','nowSevere','importedCase','noInfect'])
pd_china=pd_china.append(pd1)
pd1=pd.DataFrame(listData1['chinaAdd'],index=['chinaAdd'], columns=['confirm', 'heal','dead','suspect','nowConfirm','nowSevere','importedCase','noInfect'])
pd_china=pd_china.append(pd1)
pd_china['lastUpdateTime']=listTime
pd_china=pd_china.rename(columns={"confirm": "累计确诊", "heal": "治愈","dead":"累计死亡","suspect":"疑是患者","nowConfirm":"现有患者","importedCase":"境外输入","noInfect":"无症状感染者","lastUpdateTime":"最近更新时间","nowSevere":"重症患者"})
pd_china=pd_china.rename(index={"chinaTotal":"中国累计","chinaAdd":"中国新增"})
pd_china
