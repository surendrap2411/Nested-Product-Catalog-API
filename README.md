
#Catalogue System
REST API for a Structured Product Catalogue System

## Introduction
This project aims to implement a RESTful API for a product catalogue system, utilizing Java and MySql to store and manage products with a complex, nested data structure.


## Features

- Create Product: Add new products to the catalogue.
- Read Product: Retrieve product details including name, description, price, categories, attributes, availability, and user ratings.
- Update Product: Modify existing product information.
- Delete Product: Remove products from the catalogue.
- Search Products: Search for products based on various criteria such as name, category, price range, etc.
- Pagination and Sorting: Implement pagination and sorting in the product list retrieval endpoint
- User Ratings: Allow users to rate products and leave optional comments.


## Product Entity Structure

- Create Product: Add new products to the catalogue.
- name: The name of the product. 
- description: A text description of the product.
- price: The price of the product. 
- categories: An array of categories (strings) the product belongs to.
- attributes: An array of key-value pairs (objects) for additional attributes such as size, color, brand, etc. 
- availability: An object containing:
    - inStock: A boolean indicating if the product is in stock.
    - quantity: An integer representing the available quantity.
- ratings: An array of objects representing user ratings, each with:
    - userId: A unique identifier for the user who gave the rating.
    - rating: A numerical rating value.
    - comment: An optional text comment on the rating.
## Technologies Used

- Java
- Spring Boot,spring data jpa
- Hibernate(ORM)
- MySql


## Installation
 - Clone the repository.
 - Install dependencies.
 - Configure MySql connection(Hibernate(ORM))
 - Run the application.
    
## Usage

- Start the application.
- Access the API endpoints using a tool Postman.
- Testing Api using endpoints 

## Running Tests

- To run tests on Postman
   
   1. http://localhost:8090/products
   Retrieve all product details as well as refering data of that product
   [rating , availability]
```bash
 [
    {
        "id": 1,
        "name": "Product Name",
        "desciption": "Product Description",
        "price": 99.99,
        "categories": "Category1, Category2",
        "attributes": "Attribute1, Attribute2",
        "availibility": {
            "id": 2,
            "quantity": 100,
            "instock": true
        },
        "rating": [
            {
                "id": 1,
                "userId": 1,
                "comment": "Great product!",
                "rating": 4.5,
                "productId": 1
            },
            {
                "id": 2,
                "userId": 2,
                "comment": "Great product!",
                "rating": 4.5,
                "productId": 1
            }
        ]
    },
    {
        "id": 2,
        "name": "Smartphone XYZ",
        "desciption": null,
        "price": 799.99,
        "categories": "Electronics, Mobile Phones",
        "attributes": "5G Support, 128GB Storage",
        "availibility": {
            "id": 6,
            "quantity": 100,
            "instock": true
        },
        "rating": [
            {
                "id": 7,
                "userId": 1,
                "comment": "Great product!",
                "rating": 4.5,
                "productId": 2
            }
        ]
    },
    {
        "id": 3,
        "name": "Smartphone XYZ",
        "desciption": null,
        "price": 799.99,
        "categories": "Electronics, Mobile Phones",
        "attributes": "5G Support, 128GB Storage",
        "availibility": {
            "id": 7,
            "quantity": 1001,
            "instock": true
        },
        "rating": [
            {
                "id": 12,
                "userId": 22,
                "comment": "Great product!",
                "rating": 4.5,
                "productId": 3
            },
            {
                "id": 13,
                "userId": 12,
                "comment": "Great product!",
                "rating": 4.5,
                "productId": 3
            }
        ]
    },
    {
        "id": 4,
        "name": "Smartphone ABC",
        "desciption": "A high-performance smartphone with 4G connectivity and 64GB storage.",
        "price": 599.99,
        "categories": "Electronics, Mobile Phones",
        "attributes": "4G Support, 64GB Storage",
        "availibility": {
            "id": 9,
            "quantity": 0,
            "instock": false
        },
        "rating": [
            {
                "id": 14,
                "userId": 112,
                "comment": "Great product!",
                "rating": 5.0,
                "productId": 4
            }
        ]
    },
    {
        "id": 6,
        "name": "Product Name",
        "desciption": null,
        "price": 99.99,
        "categories": "Category1, Category2",
        "attributes": "Attribute1, Attribute2",
        "availibility": {
            "id": 12,
            "quantity": 100,
            "instock": true
        },
        "rating": [
            {
                "id": 16,
                "userId": 1,
                "comment": "Excellent product!",
                "rating": 4.5,
                "productId": 6
            },
            {
                "id": 19,
                "userId": 5,
                "comment": "Impressive product!",
                "rating": 4.5,
                "productId": 6
            }
        ]
    },
    {
        "id": 7,
        "name": "Samsung 55\" QLED Smart TV",
        "desciption": null,
        "price": 1299.99,
        "categories": "Televisions, Electronics",
        "attributes": "55-inch QLED display, 4K resolution, Quantum HDR, Smart TV functionality",
        "availibility": {
            "id": 13,
            "quantity": 1100,
            "instock": true
        },
        "rating": [
            {
                "id": 17,
                "userId": 2,
                "comment": "Outstanding product!",
                "rating": 4.5,
                "productId": 7
            },
            {
                "id": 20,
                "userId": 10,
                "comment": "Highly recommended!",
                "rating": 4.5,
                "productId": 7
            }
        ]
    },
    {
        "id": 8,
        "name": "Dell XPS 15 Laptop",
        "desciption": null,
        "price": 1799.99,
        "categories": "Laptops, Electronics",
        "attributes": "15.6-inch 4K OLED display, Intel Core i7 processor, 16GB RAM, 512GB SSD",
        "availibility": {
            "id": 14,
            "quantity": 0,
            "instock": false
        },
        "rating": [
            {
                "id": 18,
                "userId": 8,
                "comment": "Amazing product!",
                "rating": 4.5,
                "productId": 8
            }
        ]
    }
]
   
  # 2. http://localhost:8099/products/sort/price 
  # //sorting the product data accourding to filed
```bash
 [
    {
        "id": 8,
        "name": "Dell XPS 15 Laptop",
        "desciption": null,
        "price": 1799.99,
        "categories": "Laptops, Electronics",
        "attributes": "15.6-inch 4K OLED display, Intel Core i7 processor, 16GB RAM, 512GB SSD",
        "availibility": {
            "id": 14,
            "quantity": 0,
            "instock": false
        },
        "rating": [
            {
                "id": 18,
                "userId": 8,
                "comment": "Amazing product!",
                "rating": 4.5,
                "productId": 8
            }
        ]
    },
    {
        "id": 1,
        "name": "Product Name",
        "desciption": "Product Description",
        "price": 99.99,
        "categories": "Category1, Category2",
        "attributes": "Attribute1, Attribute2",
        "availibility": {
            "id": 2,
            "quantity": 100,
            "instock": true
        },
        "rating": [
            {
                "id": 1,
                "userId": 1,
                "comment": "Great product!",
                "rating": 4.5,
                "productId": 1
            },
            {
                "id": 2,
                "userId": 2,
                "comment": "Great product!",
                "rating": 4.5,
                "productId": 1
            }
        ]
    },
    {
        "id": 6,
        "name": "Product Name",
        "desciption": null,
        "price": 99.99,
        "categories": "Category1, Category2",
        "attributes": "Attribute1, Attribute2",
        "availibility": {
            "id": 12,
            "quantity": 100,
            "instock": true
        },
        "rating": [
            {
                "id": 16,
                "userId": 1,
                "comment": "Excellent product!",
                "rating": 4.5,
                "productId": 6
            },
            {
                "id": 19,
                "userId": 5,
                "comment": "Impressive product!",
                "rating": 4.5,
                "productId": 6
            }
        ]
    },
    {
        "id": 7,
        "name": "Samsung 55\" QLED Smart TV",
        "desciption": null,
        "price": 1299.99,
        "categories": "Televisions, Electronics",
        "attributes": "55-inch QLED display, 4K resolution, Quantum HDR, Smart TV functionality",
        "availibility": {
            "id": 13,
            "quantity": 1100,
            "instock": true
        },
        "rating": [
            {
                "id": 17,
                "userId": 2,
                "comment": "Outstanding product!",
                "rating": 4.5,
                "productId": 7
            },
            {
                "id": 20,
                "userId": 10,
                "comment": "Highly recommended!",
                "rating": 4.5,
                "productId": 7
            }
        ]
    },
    {
        "id": 4,
        "name": "Smartphone ABC",
        "desciption": "A high-performance smartphone with 4G connectivity and 64GB storage.",
        "price": 599.99,
        "categories": "Electronics, Mobile Phones",
        "attributes": "4G Support, 64GB Storage",
        "availibility": {
            "id": 9,
            "quantity": 0,
            "instock": false
        },
        "rating": [
            {
                "id": 14,
                "userId": 112,
                "comment": "Great product!",
                "rating": 5.0,
                "productId": 4
            }
        ]
    },
    {
        "id": 2,
        "name": "Smartphone XYZ",
        "desciption": null,
        "price": 799.99,
        "categories": "Electronics, Mobile Phones",
        "attributes": "5G Support, 128GB Storage",
        "availibility": {
            "id": 6,
            "quantity": 100,
            "instock": true
        },
        "rating": [
            {
                "id": 7,
                "userId": 1,
                "comment": "Great product!",
                "rating": 4.5,
                "productId": 2
            }
        ]
    },
    {
        "id": 3,
        "name": "Smartphone XYZ",
        "desciption": null,
        "price": 799.99,
        "categories": "Electronics, Mobile Phones",
        "attributes": "5G Support, 128GB Storage",
        "availibility": {
            "id": 7,
            "quantity": 1001,
            "instock": true
        },
        "rating": [
            {
                "id": 12,
                "userId": 22,
                "comment": "Great product!",
                "rating": 4.5,
                "productId": 3
            },
            {
                "id": 13,
                "userId": 12,
                "comment": "Great product!",
                "rating": 4.5,
                "productId": 3
            }
        ]
    }
]

  #// 3.  http://localhost:8099/api/pagination/0/4
   # pagination impl on product data  
```bash
{
    "content": [
        {
            "id": 1,
            "name": "Product Name",
            "desciption": "Product Description",
            "price": 99.99,
            "categories": "Category1, Category2",
            "attributes": "Attribute1, Attribute2",
            "availibility": {
                "id": 2,
                "quantity": 100,
                "instock": true
            },
            "rating": [
                {
                    "id": 1,
                    "userId": 1,
                    "comment": "Great product!",
                    "rating": 4.5,
                    "productId": 1
                },
                {
                    "id": 2,
                    "userId": 2,
                    "comment": "Great product!",
                    "rating": 4.5,
                    "productId": 1
                }
            ]
        },
        {
            "id": 2,
            "name": "Smartphone XYZ",
            "desciption": null,
            "price": 799.99,
            "categories": "Electronics, Mobile Phones",
            "attributes": "5G Support, 128GB Storage",
            "availibility": {
                "id": 6,
                "quantity": 100,
                "instock": true
            },
            "rating": [
                {
                    "id": 7,
                    "userId": 1,
                    "comment": "Great product!",
                    "rating": 4.5,
                    "productId": 2
                }
            ]
        },
        {
            "id": 3,
            "name": "Smartphone XYZ",
            "desciption": null,
            "price": 799.99,
            "categories": "Electronics, Mobile Phones",
            "attributes": "5G Support, 128GB Storage",
            "availibility": {
                "id": 7,
                "quantity": 1001,
                "instock": true
            },
            "rating": [
                {
                    "id": 12,
                    "userId": 22,
                    "comment": "Great product!",
                    "rating": 4.5,
                    "productId": 3
                },
                {
                    "id": 13,
                    "userId": 12,
                    "comment": "Great product!",
                    "rating": 4.5,
                    "productId": 3
                }
            ]
        },
        {
            "id": 4,
            "name": "Smartphone ABC",
            "desciption": "A high-performance smartphone with 4G connectivity and 64GB storage.",
            "price": 599.99,
            "categories": "Electronics, Mobile Phones",
            "attributes": "4G Support, 64GB Storage",
            "availibility": {
                "id": 9,
                "quantity": 0,
                "instock": false
            },
            "rating": [
                {
                    "id": 14,
                    "userId": 112,
                    "comment": "Great product!",
                    "rating": 5.0,
                    "productId": 4
                }
            ]
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 4,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "unpaged": false,
        "paged": true
    },
    "last": false,
    "totalElements": 7,
    "totalPages": 2,
    "size": 4,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "numberOfElements": 4,
    "first": true,
    "empty": false
}


# the particular end point for particular entity
1 get product..http://localhost:8085/products
2 get/id product..http://localhost:8085/products/id
3. create product..http://localhost:8088/products/add 
3. update product..http://localhost:8085/products/update/id
5. delete product..http://localhost:8086/products/delete/id

#ratibg entity endpoint
1  retrive rating http://localhost:8088/rating/id
2. retrive/id rating..http://localhost:8088/rating/id
3 create rating ..http://localhost:8088/rating/add
4. update rating...http://localhost:8088/rating/update/id
5. delete rating... http://localhost:8088/Rating/delete/id

#availibility entity endpoint
1  retrive availibility http://localhost:8088/availibility/id
2. retrive/id availibility..http://localhost:8088/availibility/id
3 create availibility ..http://localhost:8088/availibility/add
4. update availibility...http://localhost:8088/availibility/update/id
5. delete availibility... http://localhost:8088/availibility/delete/id
    
      
## Contributors
- Surendra Patil (https://www.github.com/octokatherine)

