import requests
from bs4 import BeautifulSoup

result = requests.get("http://www.plantnative.org/rpl-denjny.htm")

src = result.content
soup = BeautifulSoup(src, "html.parser")

def scrape_function() -> []:
    '''
    Goes into the first textrpl class section, and creates a list 
    of lines where each line contains all plant data.
    **Could definitely be condensed into a single loop but who cares**
    '''
    print("====================Tree Data====================")

    tree_name_list = []
    tree_names = soup.find_all("td",class_="textrpl")[1].stripped_strings
    for name in tree_names:
        tree_name_list.append(name)
    #print(tree_name_list)

    tree_scientific_name_list = []
    tree_scientific_names = soup.find_all("td",class_="textrpl")[2].stripped_strings
    for name in tree_scientific_names:
        tree_scientific_name_list.append(name)
    #print(tree_scientific_name_list)

    tree_sun_level_list = []
    tree_sun_levels = soup.find_all("td",class_="textrpl")[3].stripped_strings
    for sun_level in tree_sun_levels:
        tree_sun_level_list.append(sun_level)
    #print(tree_sun_level_list)

    tree_moisture_level_list= []
    tree_moisture_levels = soup.find_all("td",class_="textrpl")[4].stripped_strings
    for moisture_level in tree_moisture_levels:
        tree_moisture_level_list.append(moisture_level)
    #print(tree_moisture_level_list)

    tree_height_list = []
    tree_heights = soup.find_all("td",class_="textrpl")[5].stripped_strings
    for height in tree_heights:
        tree_height_list.append(height)
    #print(tree_height_list)
    
    final_tree_output = list(zip(tree_name_list,tree_scientific_name_list,\
        tree_sun_level_list,tree_moisture_level_list,tree_height_list))
    
    data_file = open("database.txt", "w")
    for item in final_tree_output:
        item = str(item)
        #item.replace("(","")
        #item.replace(")","")
        data_file.write("tree, " + item + "\n")
    

    
    print("\n")
    print("====================Shrub Data====================")
    
    shrub_name_list = []
    shrub_names = soup.find_all("td",class_="textrpl")[6].stripped_strings
    for name in shrub_names:
        shrub_name_list.append(name)
    #print(shrub_name_list)

    shrub_scientific_name_list = []
    shrub_scientific_names = soup.find_all("td",class_="textrpl")[7].stripped_strings
    for name in shrub_scientific_names:
        shrub_scientific_name_list.append(name)
    #print(shrub_scientific_name_list)

    shrub_sun_level_list = []
    shrub_sun_levels = soup.find_all("td",class_="textrpl")[8].stripped_strings
    for sun_level in shrub_sun_levels:
        shrub_sun_level_list.append(sun_level)
    #print(shrub_sun_level_list)

    shrub_moisture_level_list = []
    shrub_moisture_levels = soup.find_all("td",class_="textrpl")[9].stripped_strings
    for moisture_level in shrub_moisture_levels:
        shrub_moisture_level_list.append(moisture_level)
    #print(shrub_moisture_list)

    shrub_height_list = []
    shrub_heights = soup.find_all("td",class_="textrpl")[10].stripped_strings
    for height in shrub_heights:
        shrub_height_list.append(height)
    #print(shrub_height_list)
    
    final_shrub_output = list(zip(shrub_name_list,shrub_scientific_name_list,\
        shrub_sun_level_list,shrub_moisture_level_list,shrub_height_list))
    
    
    for item in final_shrub_output:
        item = str(item)
        #item.replace("(","")
        #item.replace(")","")
        data_file.write("shrub, " + item + "\n")
    
    
    print("\n")
    print("====================Vine Data====================")
    
    vine_name_list = []
    vine_names = soup.find_all("td",class_="textrpl")[11].stripped_strings
    for name in vine_names:
        vine_name_list.append(name)
    #print(vine_name_list)

    vine_scientific_name_list = []
    vine_scientific_names = soup.find_all("td",class_="textrpl")[12].stripped_strings
    for name in vine_scientific_names:
        vine_scientific_name_list.append(name)
    #print(vine_scientific_name_list)

    vine_sun_level_list = []
    vine_sun_levels = soup.find_all("td",class_="textrpl")[13].stripped_strings
    for sun_level in vine_sun_levels:
        vine_sun_level_list.append(sun_level)
    #print(vine_sun_level_list)

    vine_moisture_level_list = []
    vine_moisture_levels = soup.find_all("td",class_="textrpl")[14].stripped_strings
    for moisture_level in vine_moisture_levels:
        vine_moisture_level_list.append(moisture_level)
    #print(vine_moisture_list)

    vine_height_list = []
    vine_heights = soup.find_all("td",class_="textrpl")[15].stripped_strings
    for height in vine_heights:
        vine_height_list.append(height)
    #print(vine_height_list)
    
    final_vine_output = list(zip(vine_name_list,vine_scientific_name_list,\
        vine_sun_level_list,vine_moisture_level_list,vine_height_list))
    
    
    for item in final_vine_output:
        item = str(item)
        #item.replace("(","")
        #item.replace(")","")
        data_file.write("vine, " + item + "\n")
    

    
    print("\n")
    print("====================Flowering Perennials Data====================")
    
    flower_name_list = []
    flower_names = soup.find_all("td",class_="textrpl")[16].stripped_strings
    for name in flower_names:
        flower_name_list.append(name)
    #print(flower_name_list)

    flower_scientific_name_list = []
    flower_scientific_names = soup.find_all("td",class_="textrpl")[17].stripped_strings
    for name in flower_scientific_names:
        flower_scientific_name_list.append(name)
    #print(flower_scientific_name_list)
    flower_scientific_name_list[0] = flower_scientific_name_list[0].replace("\r","")
    flower_scientific_name_list[0] = flower_scientific_name_list[0].replace("\n","")
    flower_scientific_name_list[0] = flower_scientific_name_list[0].replace(" ","")

    flower_sun_level_list = []
    flower_sun_levels = soup.find_all("td",class_="textrpl")[18].stripped_strings
    for sun_level in flower_sun_levels:
        flower_sun_level_list.append(sun_level)
    #print(flower_sun_level_list)

    flower_moisture_level_list = []
    flower_moisture_levels = soup.find_all("td",class_="textrpl")[19].stripped_strings
    for moisture_level in flower_moisture_levels:
        flower_moisture_level_list.append(moisture_level)
    #print(flower_moisture_list)

    flower_height_list = []
    flower_heights = soup.find_all("td",class_="textrpl")[20].stripped_strings
    for height in flower_heights:
        flower_height_list.append(height)
    #print(flower_height_list)
    
    final_flower_output = list(zip(flower_name_list,flower_scientific_name_list,\
        flower_sun_level_list,flower_moisture_level_list,flower_height_list))
    

    for item in final_flower_output:
        item = str(item)
        #item.replace("(","")
        #item.replace(")","")
        data_file.write("flower, " + item + "\n")
    

    
    print("\n")
    print("====================Perennial Ferns Data====================")
    
    fern_name_list = []
    fern_names = soup.find_all("td",class_="textrpl")[21].stripped_strings
    for name in fern_names:
        fern_name_list.append(name)
    #print(fern_name_list)
    fern_name_list[0] = fern_name_list[0].replace("\r","")
    fern_name_list[0] = fern_name_list[0].replace("\n","")
    fern_name_list[0] = fern_name_list[0].replace(" ","")

    fern_scientific_name_list = []
    fern_scientific_names = soup.find_all("td",class_="textrpl")[22].stripped_strings
    for name in fern_scientific_names:
        fern_scientific_name_list.append(name)
    #print(fern_scientific_name_list)
    fern_scientific_name_list[0] = fern_scientific_name_list[0].replace("\r","")
    fern_scientific_name_list[0] = fern_scientific_name_list[0].replace("\n","")
    fern_scientific_name_list[0] = fern_scientific_name_list[0].replace(" ","")

    fern_sun_level_list = []
    fern_sun_levels = soup.find_all("td",class_="textrpl")[23].stripped_strings
    for sun_level in fern_sun_levels:
        fern_sun_level_list.append(sun_level)
    #print(fern_sun_level_list)

    fern_moisture_level_list = []
    fern_moisture_levels = soup.find_all("td",class_="textrpl")[24].stripped_strings
    for moisture_level in fern_moisture_levels:
        fern_moisture_level_list.append(moisture_level)
    #print(fern_moisture_list)

    fern_height_list = []
    fern_heights = soup.find_all("td",class_="textrpl")[25].stripped_strings
    for height in fern_heights:
        fern_height_list.append(height)
    #print(fern_height_list)
    
    final_fern_output = list(zip(fern_name_list,fern_scientific_name_list,\
        fern_sun_level_list,fern_moisture_level_list,fern_height_list))
    
    
    for item in final_fern_output:
        item = str(item)
        #item.replace("(","")
        #item.replace(")","")
        data_file.write("fern, " + item + "\n")
    

    
    print("\n")
    print("====================Grasses Data====================")
    
    grasses_name_list = []
    grasses_names = soup.find_all("td",class_="textrpl")[26].stripped_strings
    for name in grasses_names:
        grasses_name_list.append(name)
    #print(grasses_name_list)

    grasses_scientific_name_list = []
    grasses_scientific_names = soup.find_all("td",class_="textrpl")[27].stripped_strings
    for name in grasses_scientific_names:
        grasses_scientific_name_list.append(name)
    #print(grasses_scientific_name_list)
    grasses_scientific_name_list[0] = grasses_scientific_name_list[0].replace("\r","")
    grasses_scientific_name_list[0] = grasses_scientific_name_list[0].replace("\n","")
    grasses_scientific_name_list[0] = grasses_scientific_name_list[0].replace(" ","")

    grasses_sun_level_list = []
    grasses_sun_levels = soup.find_all("td",class_="textrpl")[28].stripped_strings
    for sun_level in grasses_sun_levels:
        grasses_sun_level_list.append(sun_level)
    #print(grasses_sun_level_list)

    grasses_moisture_level_list = []
    grasses_moisture_levels = soup.find_all("td",class_="textrpl")[29].stripped_strings
    for moisture_level in grasses_moisture_levels:
        grasses_moisture_level_list.append(moisture_level)
    #print(grasses_moisture_list)

    grasses_height_list = []
    grasses_heights = soup.find_all("td",class_="textrpl")[30].stripped_strings
    for height in grasses_heights:
        grasses_height_list.append(height)
    #print(grasses_height_list)
    
    final_grasses_output = list(zip(grasses_name_list,grasses_scientific_name_list,\
        grasses_sun_level_list,grasses_moisture_level_list,grasses_height_list))
    

    for item in final_grasses_output:
        item = str(item)
        #item.replace("(","")
        #item.replace(")","")
        data_file.write("grass, " + item + "\n")
    data_file.close

    

def main():
    scrape_function()


if __name__ == "__main__":
    main()